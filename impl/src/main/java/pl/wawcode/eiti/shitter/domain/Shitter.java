package pl.wawcode.eiti.shitter.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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

    @ColumnDefault("5")
    private long reputationCounter;

    private String openingHour;
    private String closingHour;

    private byte[] image;

    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Voter> voters = new HashSet<>();
}
