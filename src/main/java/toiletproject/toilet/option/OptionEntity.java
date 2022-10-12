package toiletproject.toilet.option;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import toiletproject.toilet.review.dto.ReviewAddDto;
import toiletproject.toilet.review.entity.ReviewEntity;
import toiletproject.toilet.toilets.entity.ToiletEntity;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Table(name = "options")
@Entity
public class OptionEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id")
    private Long id;

    @Column(nullable = false, columnDefinition="BOOLEAN DEFAULT false")
    private Boolean common;

    @Column(nullable = false, columnDefinition="BOOLEAN DEFAULT false")
    private Boolean locked;

    @ElementCollection
    private List<Integer> types;

    @Column(nullable = false, columnDefinition="BOOLEAN DEFAULT true")
    private Boolean paper;

    @Column(nullable = false, columnDefinition="BOOLEAN DEFAULT false")
    private Boolean disabled;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "toilet_id")
    private ToiletEntity toilet;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private ReviewEntity review;

    public void setToilet(ToiletEntity toilet) {
        this.toilet = toilet;
        toilet.setOption(this);
    }

    public void setReview(ReviewEntity review) {
        this.review = review;
        review.setOption(this);
    }

    public static OptionEntity createOption(ToiletEntity toilet, ReviewEntity review, ReviewAddDto reviewDto) {
        OptionEntity option = new OptionEntity();
        option.setToilet(toilet);
        option.setReview(review);
        option.common = reviewDto.getCommon();
        option.locked = reviewDto.getLocked();
        option.types = reviewDto.getTypes();
        option.paper = reviewDto.getPaper();
        option.disabled = reviewDto.getDisabled();
        return option;
    }
}
