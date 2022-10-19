package toiletproject.toilet.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import toiletproject.toilet.user.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter @Setter
public class UserReviewsToiletsDto {

    private Long id;
    private String nickname;
    private String email;
    private String imgUrl;
    private List<UserReviewsDto> userReviews;
    private List<UserToiletsDto> userToilets;

    public UserReviewsToiletsDto(UserEntity user) {
        id = user.getId();
        nickname = user.getNickname();
        email = user.getEmail();
        imgUrl = user.getImgUrl();
        userReviews = user.getReviews().stream()
                .map(UserReviewsDto::new)
                .collect(Collectors.toList());
        userToilets = user.getToilets().stream()
                .map(UserToiletsDto::new)
                .collect(Collectors.toList());
    }
}
