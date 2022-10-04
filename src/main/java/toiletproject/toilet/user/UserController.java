package toiletproject.toilet.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import toiletproject.toilet.config.auth.PrincipalDetails;
import toiletproject.toilet.user.dto.UserLoginReqDto;
import toiletproject.toilet.user.dto.UserLoginResDto;
import toiletproject.toilet.user.dto.UserRegisterReqDto;
import toiletproject.toilet.user.dto.UserResponseDto;
import toiletproject.toilet.user.entity.UserEntity;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/users")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRegisterReqDto userRegisterReqDto) {
        return userService.join(userRegisterReqDto);
    }

    @PostMapping("/login")
    public UserLoginResDto login(@RequestBody @Valid UserLoginReqDto userLoginReqDto) {
        return userService.login(userLoginReqDto);
    }

    @GetMapping()
    public UserResponseDto getCurrentUser(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        UserEntity user = principalDetails.getAccount();
        return new UserResponseDto(user);
    }
}