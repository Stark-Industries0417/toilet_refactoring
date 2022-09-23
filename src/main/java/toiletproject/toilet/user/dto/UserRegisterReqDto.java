package toiletproject.toilet.user.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter @Setter
public class UserRegisterReqDto {

    @Email
    @NotBlank(message = "이메일은 필수 입력 값 입니다.")
    private String email;

    @NotBlank(message = "닉네임은 필수 입력 값 입니다.")
    private String nickname;

    @NotBlank(message = "비밀번호는 필수 입력 값 입니다.")
    private String password;

    @NotBlank(message = "비밀번호는 필수 입력 값 입니다.")
    private String checkPassword;
}