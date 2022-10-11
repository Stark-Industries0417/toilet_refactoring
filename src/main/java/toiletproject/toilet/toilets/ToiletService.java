package toiletproject.toilet.toilets;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toiletproject.toilet.toilets.dto.ToiletAddress;
import toiletproject.toilet.toilets.dto.ToiletDto;
import toiletproject.toilet.toilets.entity.ToiletEntity;
import toiletproject.toilet.user.UserRepository;
import toiletproject.toilet.user.entity.UserEntity;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ToiletService {

    private final ToiletRepository toiletRepository;
    private final UserRepository userRepository;

    @Transactional
    public ToiletDto addToilet(UserEntity auth, ToiletDto toiletAddDto) {
        UserEntity user = userRepository.findById(auth.getId()).get();
        ToiletEntity toilet = ToiletEntity.createToiletEntity(toiletAddDto);
        toilet.setUser(user);
        return new ToiletDto(toiletRepository.save(toilet));
    }

    public ToiletDto getToilet(ToiletAddress addressDto) {
        return new ToiletDto(toiletRepository.findByAddress(addressDto.getAddress())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 주소 입니다.")));
    }
}