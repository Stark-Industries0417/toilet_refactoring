package toiletproject.toilet.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toiletproject.toilet.config.jwt.JwtTokenProvider;
import toiletproject.toilet.user.dto.UserLoginReqDto;
import toiletproject.toilet.user.dto.UserLoginResDto;
import toiletproject.toilet.user.dto.UserRegisterReqDto;
import toiletproject.toilet.user.dto.UserResponseDto;
import toiletproject.toilet.user.entity.UserEntity;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public UserResponseDto join(UserRegisterReqDto joinReqDto, String userImg){

        validatePasswordCheck(joinReqDto);

        joinReqDto.setPassword(passwordEncoder.encode(joinReqDto.getPassword()));

        UserEntity user = UserEntity.createUserEntity(joinReqDto);
        user.setImgUrl(userImg);
        UserEntity savedUser = userRepository.save(user);

        return new UserResponseDto(savedUser);
    }
    private void validatePasswordCheck(UserRegisterReqDto joinReqDto){
        if (!joinReqDto.getPassword().equals(joinReqDto.getCheckPassword())) {
            throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
        }
    }

    @Transactional(readOnly = true)
    public UserLoginResDto login(UserLoginReqDto loginReq) {
        UserEntity user = userRepository.findByEmail(loginReq.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 이메일 입니다."));

        if(!passwordEncoder.matches(loginReq.getPassword(), user.getPassword())) {
            throw new RuntimeException("없는 이메일 이거나 비밀번호가 틀렸습니다.");
        }

        return UserLoginResDto
                .builder()
                .id(user.getId())
                .email(user.getEmail())
                .nickname(user.getNickname())
                .imgUrl(user.getImgUrl())
                .token(jwtTokenProvider.createToken(user.getId(), user.getEmail()))
                .build();
    }
}