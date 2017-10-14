package pl.wawcode.eiti.shitter.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface ShitterRepository extends CrudRepository<Shitter, Long> {
    List<Shitter> findByLocationBetweenAndReputationCounterGreaterThan(ShitterLocation downLeft, ShitterLocation upRight,
                                                                       Long minimumReputation);
}
