package toiletproject.toilet.config.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import toiletproject.toilet.user.UserRepository;
import toiletproject.toilet.user.entity.UserEntity;

@Slf4j
@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
        log.info("nickname = {}", nickname);

        UserEntity userEntity = userRepository.findByNickname(nickname)
                .orElseThrow(() -> new UsernameNotFoundException("찾을 수 없는 닉네임 입니다."));

        log.info("find.nickname = {}", userEntity.getNickname());
        return new PrincipalDetails(userEntity);
    }
}
