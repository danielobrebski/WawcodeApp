package pl.wawcode.eiti.shitter.domain;

import lombok.RequiredArgsConstructor;
import pl.wawcode.eiti.shitter.dtos.ShitterInDto;

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
}
