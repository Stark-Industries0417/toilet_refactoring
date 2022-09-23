package toiletproject.toilet.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import toiletproject.toilet.user.dto.UserRegisterReqDto;
import toiletproject.toilet.user.dto.UserRegisterResDto;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/users")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public UserRegisterResDto register(@RequestBody @Valid UserRegisterReqDto userRegisterReqDto) {
        return userService.join(userRegisterReqDto);
    }
}