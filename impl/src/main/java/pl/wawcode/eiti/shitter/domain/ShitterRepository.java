package pl.wawcode.eiti.shitter.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ShitterRepository extends CrudRepository<Shitter, Long> {
}
