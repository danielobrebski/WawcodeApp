package pl.wawcode.eiti.shitter.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Column(columnDefinition = "default 5")
    private long reputationCounter;

    private LocalDateTime openingHour;
    private LocalDateTime closingHour;

    private byte[] image;
    private String description;
}
