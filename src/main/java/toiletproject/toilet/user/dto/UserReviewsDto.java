package toiletproject.toilet.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import toiletproject.toilet.review.entity.ReviewEntity;

@NoArgsConstructor
@Getter @Setter
public class UserReviewsDto {

    private String content;
    private Integer rate;
    private Integer stack;

    public UserReviewsDto(ReviewEntity review) {
        content = review.getContent();
        rate = review.getRate();
        stack = review.getStack();
    }
}
