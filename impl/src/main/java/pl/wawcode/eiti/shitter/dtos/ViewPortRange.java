package pl.wawcode.eiti.shitter.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.wawcode.eiti.shitter.domain.ShitterLocation;

@Getter
@AllArgsConstructor
public class ViewPortRange {
    private ShitterLocation downLeftLatitudeLongitude;
    private ShitterLocation upRightLatitudeLongitude;
}
