package toiletproject.toilet.review;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toiletproject.toilet.config.auth.PrincipalDetails;
import toiletproject.toilet.option.OptionEntity;
import toiletproject.toilet.option.OptionRepository;
import toiletproject.toilet.review.dto.ReviewAddDto;
import toiletproject.toilet.review.dto.ReviewResDto;
import toiletproject.toilet.review.entity.ReviewEntity;
import toiletproject.toilet.toilets.ToiletRepository;
import toiletproject.toilet.toilets.entity.ToiletEntity;
import toiletproject.toilet.user.UserRepository;
import toiletproject.toilet.user.entity.UserEntity;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ReviewService {

    private final UserRepository userRepository;
    private final ToiletRepository toiletRepository;
    private final OptionRepository optionRepository;
    private final ReviewRepository reviewRepository;

    @Transactional
    public ReviewResDto reviewAdditional(PrincipalDetails auth, ReviewAddDto reviewAddDto, String toiletImg) {
        UserEntity user = userRepository.findByEmail(auth.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자 입니다."));
        ToiletEntity toilet = toiletRepository.findByAddress(reviewAddDto.getAddress())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 화장실 주소 입니다."));

        ReviewEntity review = ReviewEntity.createReviewEntity(user, toilet, reviewAddDto);
        review.setToiletImg(toiletImg);

        OptionEntity option = OptionEntity.createOption(toilet, review, reviewAddDto);
        optionRepository.save(option);
        return new ReviewResDto(reviewRepository.save(review));
    }
}
