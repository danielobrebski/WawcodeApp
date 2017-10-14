package pl.wawcode.eiti.shitter.dtos;

import lombok.Builder;
import lombok.Data;
import pl.wawcode.eiti.shitter.domain.ShitterLocation;

import javax.persistence.Embedded;

@Data
@Builder
public class ShitterOutDto {
    private Double latitude;
    private Double longitude;
    private Long id;
    private long reputationCounter;
}
