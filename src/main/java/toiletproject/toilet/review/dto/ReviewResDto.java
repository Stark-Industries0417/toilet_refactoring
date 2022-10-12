package toiletproject.toilet.review.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import toiletproject.toilet.review.entity.ReviewEntity;

@NoArgsConstructor
@Getter @Setter
public class ReviewResDto {

    private Long id;
    private String content;
    private Integer rate;
    private String toiletImg;
    private Integer stack;

    public ReviewResDto(ReviewEntity review) {
        id = review.getId();
        content = review.getContent();
        rate = review.getRate();
        toiletImg = review.getToiletImg();
        stack = review.getStack();
    }
}
