package pl.wawcode.eiti.shitter.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor
//@NoArgsConstructor
class ShitterLocation {
    private Long latitude;
    private Long longitude;
    public ShitterLocation() {

    }
}
