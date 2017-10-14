package pl.wawcode.eiti.shitter.domain;

import javax.persistence.Embeddable;

@Embeddable
class ShitterLocation {
    Long latitude;
    Long longitude;
}
