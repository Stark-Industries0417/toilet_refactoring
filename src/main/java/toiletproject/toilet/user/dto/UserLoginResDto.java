package toiletproject.toilet.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserLoginResDto extends UserResponseDto {

    private String token;

    @Builder
    public UserLoginResDto(Long id, String email, String nickname, String imgUrl, String token) {
        super.setId(id);
        super.setEmail(email);
        super.setNickname(nickname);
        super.setImgUrl(imgUrl);
        this.token = token;
    }
}