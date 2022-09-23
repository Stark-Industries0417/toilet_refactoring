package toiletproject.toilet.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toiletproject.toilet.config.jwt.JwtTokenProvider;
import toiletproject.toilet.user.dto.UserRegisterReqDto;
import toiletproject.toilet.user.dto.UserRegisterResDto;
import toiletproject.toilet.user.entity.UserEntity;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public UserRegisterResDto join(UserRegisterReqDto joinReqDto){

        validatePasswordCheck(joinReqDto);

        joinReqDto.setPassword(passwordEncoder.encode(joinReqDto.getPassword()));

        UserEntity user = UserEntity.createUserEntity(joinReqDto);
        UserEntity savedUser = userRepository.save(user);

        return new UserRegisterResDto(savedUser);
    }
    private void validatePasswordCheck(UserRegisterReqDto joinReqDto){
        if (!joinReqDto.getPassword().equals(joinReqDto.getCheckPassword())) {
            throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
        }
    }
}