package pl.wawcode.eiti.shitter.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface ShitterRepository extends CrudRepository<Shitter, Long> {

    @Query("SELECT s FROM Shitter s WHERE s.location.latitude > :#{#downLeft.latitude} " +
            "AND s.location.longitude > :#{#downLeft.longitude} " +
            "AND s.location.latitude < :#{#upRight.latitude} " +
            "AND s.location.longitude < :#{#upRight.longitude}")
    List<Shitter> findByLocationBetween(@Param("downLeft") ShitterLocation downLeft,
                                        @Param("upRight") ShitterLocation upRight);
}
