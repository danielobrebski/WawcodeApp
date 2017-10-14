package pl.wawcode.eiti.shitter.dtos;

import lombok.Getter;
import pl.wawcode.eiti.shitter.domain.ShitterLocation;

@Getter
public class ViewPortRange {
    private ShitterLocation downLeftLatitudeLongitude;
    private ShitterLocation upRightLatitudeLongitude;
}
