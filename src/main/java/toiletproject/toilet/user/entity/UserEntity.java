package toiletproject.toilet.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import toiletproject.toilet.config.entity.BaseTimeEntity;
import toiletproject.toilet.user.dto.UserRegisterReqDto;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@DynamicInsert
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

    @Column(nullable = false, columnDefinition =
            "varchar(255) default 'https://toiletprofile.s3.ap-northeast-2.amazonaws.com/Profile-Image.svg'")
    private String imgUrl;

    public static UserEntity createUserEntity(UserRegisterReqDto dto) {
        return UserEntity.builder()
                .email(dto.getEmail())
                .nickname(dto.getNickname())
                .password(dto.getPassword())
                .build();
    }
}