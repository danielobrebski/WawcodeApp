package pl.wawcode.eiti.shitter.domain;

import lombok.RequiredArgsConstructor;
import pl.wawcode.eiti.shitter.dtos.ShitterInDto;

@RequiredArgsConstructor
class ShitterService {
    private final ShitterRepository shitterRepository;

    void acceptShitter(Long id) {
        Shitter shitter = shitterRepository.findOne(id);
        long reputationCounter = shitter.getReputationCounter();
        shitter.setId(reputationCounter + 1);
    }

    void addShitter(Shitter shitter) {

    }
}
