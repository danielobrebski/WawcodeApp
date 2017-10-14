package pl.wawcode.eiti.shitter;

import javax.persistence.*;

@Entity
class Shitter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Embedded
    ShitterLocation location;
}
