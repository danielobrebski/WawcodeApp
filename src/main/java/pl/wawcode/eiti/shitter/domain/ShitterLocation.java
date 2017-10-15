package pl.wawcode.eiti.shitter.domain;

import lombok.*;

import javax.persistence.Embeddable;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class ShitterLocation {
    private Double latitude;
    private Double longitude;
}
