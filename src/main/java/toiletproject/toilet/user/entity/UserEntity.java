package toiletproject.toilet.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import toiletproject.toilet.config.entity.BaseTimeEntity;
import toiletproject.toilet.toilets.entity.ToiletEntity;
import toiletproject.toilet.user.dto.UserRegisterReqDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "users")
@Entity
public class UserEntity extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String imgUrl;

    @OneToMany(mappedBy = "user")
    private List<ToiletEntity> toilets = new ArrayList<>();

    public static UserEntity createUserEntity(UserRegisterReqDto dto) {
        return UserEntity.builder()
                .email(dto.getEmail())
                .nickname(dto.getNickname())
                .password(dto.getPassword())
                .build();
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}