package pl.wawcode.eiti.shitter.domain;

import pl.wawcode.eiti.shitter.dtos.ShitterOutDto;

class ShitterFactory {
    static ShitterOutDto createOutDto(Shitter shitter) {
        return ShitterOutDto.builder()
                .latitude(shitter.getLocation().getLatitude())
                .longitude(shitter.getLocation().getLongitude())
                .build();
    }
}
