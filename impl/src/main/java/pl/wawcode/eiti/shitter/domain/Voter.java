package pl.wawcode.eiti.shitter.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class Voter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String remoteAddr;

    private LocalDateTime timestamp;
}
