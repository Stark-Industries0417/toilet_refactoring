package toiletproject.toilet.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import toiletproject.toilet.user.entity.UserEntity;

@NoArgsConstructor
@Getter @Setter
public class UserResponseDto {

    private Long id;
    private String nickname;
    private String email;
    private String imgUrl;

    public UserResponseDto(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.nickname = userEntity.getNickname();
        this.email = userEntity.getEmail();
        this.imgUrl = userEntity.getImgUrl();
    }
}
