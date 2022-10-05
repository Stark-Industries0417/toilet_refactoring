package toiletproject.toilet.user;

import lombok.RequiredArgsConstructor;
import lombok.Synchronized;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import toiletproject.toilet.config.auth.PrincipalDetails;
import toiletproject.toilet.config.aws.ImageUploadService;
import toiletproject.toilet.user.dto.UserLoginReqDto;
import toiletproject.toilet.user.dto.UserLoginResDto;
import toiletproject.toilet.user.dto.UserRegisterReqDto;
import toiletproject.toilet.user.dto.UserResponseDto;
import toiletproject.toilet.user.entity.UserEntity;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/api/users")
@RestController
public class UserController {

    private final UserService userService;
    private final ImageUploadService imageUploadService;
    private String userImg = "https://toilet-project.s3.ap-northeast-2.amazonaws.com/profile/Profile-Image.png";

    @Synchronized
    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRegisterReqDto userRegisterReqDto) {
        UserResponseDto savedUser = userService.join(userRegisterReqDto, userImg);
        userImg = "https://toilet-project.s3.ap-northeast-2.amazonaws.com/profile/Profile-Image.png";
        return savedUser;
    }

    @PostMapping("/login")
    public UserLoginResDto login(@RequestBody @Valid UserLoginReqDto userLoginReqDto) {
        return userService.login(userLoginReqDto);
    }

    @GetMapping()
    public UserResponseDto getCurrentUser(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        UserEntity user = principalDetails.getUserEntity();
        return new UserResponseDto(user);
    }

    @GetMapping("/upload")
    public void uploadToS3(@RequestPart MultipartFile image) {
        userImg = imageUploadService.uploadImage(image, "profile");
    }
}