package toiletproject.toilet.user;

import org.springframework.data.jpa.repository.JpaRepository;
import toiletproject.toilet.user.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByNickname(String nickname);
}
