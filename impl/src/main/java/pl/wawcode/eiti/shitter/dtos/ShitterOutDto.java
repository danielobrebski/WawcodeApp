package pl.wawcode.eiti.shitter.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShitterOutDto {
    private Double latitude;
    private Double longitude;
}
