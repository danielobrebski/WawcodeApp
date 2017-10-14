package pl.wawcode.eiti.shitter.domain;

import lombok.RequiredArgsConstructor;
import pl.wawcode.eiti.shitter.dtos.ShitterInDto;
import pl.wawcode.eiti.shitter.dtos.ViewPortRange;
import pl.wawcode.eiti.shitter.dtos.ShitterOutDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ShitterFacade {
    private final ShitterService shitterService;

    public void acceptShitter(Long id) {
        shitterService.acceptShitter(id);
    }

    public void addShitter(ShitterInDto shitter) {
        shitterService.addShitter(
            Shitter
                .builder()
                .location(new ShitterLocation(shitter.getLatitude(), shitter.getLongitude()))
                .build()
        );
    }

    public void rejectShitter(Long id) {
        shitterService.rejectShitter(id);
    }

    public List<ShitterOutDto> getShitters(ViewPortRange viewPortRange) {
        return shitterService.getShitters(viewPortRange)
            .stream()
            .map(shitter -> ShitterOutDto
                .builder()
                .longitude(shitter.getLocation().getLongitude())
                .latitude(shitter.getLocation().getLatitude())
                .build()
            )
            .collect(Collectors.toList());
    }
}
