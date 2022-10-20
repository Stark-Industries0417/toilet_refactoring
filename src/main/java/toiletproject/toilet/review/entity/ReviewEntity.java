package toiletproject.toilet.review.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import toiletproject.toilet.option.OptionEntity;
import toiletproject.toilet.review.dto.ReviewAddDto;
import toiletproject.toilet.toilets.entity.ToiletEntity;
import toiletproject.toilet.user.entity.UserEntity;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Table(name = "reviews", indexes = @Index(name = "i_review", columnList = "user_id, toilet_id"))
@Entity
public class ReviewEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private Integer rate = 0;

    private String toiletImg;

    private Integer stack = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "toilet_id")
    private ToiletEntity toilet;

    @OneToOne(mappedBy = "review", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private OptionEntity option;

    public void setUser(UserEntity user) {
        this.author = user;
        user.getReviews().add(this);
    }

    public void setToilet(ToiletEntity toilet) {
        this.toilet = toilet;
        toilet.getReviews().add(this);
    }

    public void setToiletImg(String toiletImg) {
        this.toiletImg = toiletImg;
    }

    public void setOption(OptionEntity option) {
        this.option = option;
    }

    public void report() {
        this.stack += 1;
    }

    public static ReviewEntity createReviewEntity(UserEntity user, ToiletEntity toilet, ReviewAddDto addDto) {
        ReviewEntity review = new ReviewEntity();
        review.setUser(user);
        review.setToilet(toilet);
        review.content = addDto.getContent();
        review.rate = addDto.getRate();

        return review;
    }
}
