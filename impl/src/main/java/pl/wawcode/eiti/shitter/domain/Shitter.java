package pl.wawcode.eiti.shitter.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class Shitter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private ShitterLocation location;

    private long reputationCounter;
}
