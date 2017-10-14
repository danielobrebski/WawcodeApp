package pl.wawcode.eiti.shitter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
class Shitter {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
}
