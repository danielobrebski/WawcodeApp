package pl.wawcode.eiti.shitter;

import javax.persistence.Embeddable;

@Embeddable
class ShitterLocation {
    Long latitude;
    Long longitude;
}
