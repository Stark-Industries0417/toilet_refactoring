package toiletproject.toilet.review;

import org.springframework.data.jpa.repository.JpaRepository;
import toiletproject.toilet.review.entity.ReviewEntity;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
}
