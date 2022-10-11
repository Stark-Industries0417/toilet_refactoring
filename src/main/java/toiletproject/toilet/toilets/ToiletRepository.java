package toiletproject.toilet.toilets;

import org.springframework.data.jpa.repository.JpaRepository;
import toiletproject.toilet.toilets.entity.ToiletEntity;

import java.util.Optional;

public interface ToiletRepository extends JpaRepository<ToiletEntity, Long> {
    Optional<ToiletEntity> findByAddress(String address);
}
