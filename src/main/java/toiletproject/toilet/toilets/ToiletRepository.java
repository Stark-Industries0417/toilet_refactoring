package toiletproject.toilet.toilets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import toiletproject.toilet.toilets.dto.ToiletAroundDto;
import toiletproject.toilet.toilets.entity.ToiletEntity;

import java.util.List;
import java.util.Optional;

public interface ToiletRepository extends JpaRepository<ToiletEntity, Long> {
    Optional<ToiletEntity> findByAddress(String address);

    @Query(nativeQuery = true,
            value = "SELECT\n" +
        "          t.*, (\n" +
        "          6371 * acos (\n" +
        "          cos ( radians(:lat) )\n" +
        "          * cos( radians( t.lat ) )\n" +
        "          * cos( radians( t.lng ) - radians(:lng) )\n" +
        "          + sin ( radians(:lat) )\n" +
        "          * sin( radians( t.lat ) )\n" +
        "          )\n" +
        "          ) AS distance,\n" +
        "          o.common, o.locked, o.paper, o.disabled\n" +
        "          FROM toilet_db.toilets as t\n" +
        "          LEFT OUTER JOIN toilet_db.options as o\n" +
        "          ON t.toilet_id = o.t_id\n" +
        "          HAVING distance < :dist\n" +
        "          ORDER BY distance\n" +
        "          LIMIT 0, 20;"
    )
    List<ToiletAroundDto> aroundToilet(
            @Param("lat") double lat,
            @Param("lng") double lng,
            @Param("dist") double dist);
}
