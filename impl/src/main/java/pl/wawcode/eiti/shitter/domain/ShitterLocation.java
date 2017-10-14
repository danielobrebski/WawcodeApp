package pl.wawcode.eiti.shitter.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Embeddable;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class ShitterLocation implements Comparable {
    Double latitude;
    Double longitude;

    @Override
    public int compareTo(Object o) {
        if (o == null) {
            return -1;
        }
        if (ShitterLocation.class.equals(o.getClass())) {
            ShitterLocation shLoc2 = (ShitterLocation) o;
            if (shLoc2.getLatitude() < this.getLatitude() && shLoc2.getLongitude() < this.getLongitude()) {
                return 1;
            } else if (shLoc2.getLatitude().equals(this.getLongitude()) && shLoc2.getLongitude().equals(this.getLongitude())) {
                return 0;
            }
        }
        return -1;
    }
}
