package pl.wawcode.eiti.shitter.domain;

import lombok.AllArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor
class ShitterLocation {
    Long latitude;
    Long longitude;
}
