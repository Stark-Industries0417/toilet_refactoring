package toiletproject.toilet.toilets.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import toiletproject.toilet.option.OptionEntity;
import toiletproject.toilet.review.entity.ReviewEntity;
import toiletproject.toilet.toilets.dto.ToiletDto;
import toiletproject.toilet.user.entity.UserEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "toilets")
@Entity
public class ToiletEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "toilet_id")
    private Long Id;

    @Column(unique = true, nullable = false)
    private String address;
    private String detailAddress;

    private int category;

    private int subway;

    @Column(nullable = false)
    private double lat;

    @Column(nullable = false)
    private double lng;

    private int stack;

    @Column(nullable = false)
    private double clean;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "o_id")
    private OptionEntity option;

    @OneToMany(mappedBy = "toilet")
    private List<ReviewEntity> reviews = new ArrayList<>();

    public static ToiletEntity createToiletEntity(ToiletDto dto) {
        return ToiletEntity.builder()
                .address(dto.getAddress())
                .detailAddress(dto.getDetailAddress())
                .category(dto.getCategory())
                .subway(dto.getSubway())
                .lat(dto.getLat())
                .lng(dto.getLng())
                .build();
    }
    public void setUser(UserEntity user) {
        this.user = user;
        user.getToilets().add(this);
    }

    public void setOption(OptionEntity option) {
        this.option = option;
    }
}