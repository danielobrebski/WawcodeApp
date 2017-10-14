package pl.wawcode.eiti.shitter.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.wawcode.eiti.shitter.domain.ShitterLocation;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class ViewPortRange implements Serializable {
    private ShitterLocation downLeftLatitudeLongitude;
    private ShitterLocation upRightLatitudeLongitude;
}
