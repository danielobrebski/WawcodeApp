package pl.wawcode.eiti.shitter.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShitterInDto {
    private Long latitude;
    private Long longitude;
}
