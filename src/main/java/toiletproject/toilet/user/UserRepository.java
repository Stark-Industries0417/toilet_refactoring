package toiletproject.toilet.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import toiletproject.toilet.user.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByNickname(String nickname);
    Optional<UserEntity> findByEmail(String email);

    @Query("SELECT distinct u FROM UserEntity u" +
            " JOIN FETCH u.reviews" +
            " JOIN FETCH u.toilets t" +
            " JOIN FETCH t.option")
    List<UserEntity> findAllReviewOfUser();
}
