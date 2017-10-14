package pl.wawcode.eiti.shitter.domain;

import lombok.RequiredArgsConstructor;
import pl.wawcode.eiti.shitter.dtos.ShitterInDto;

@RequiredArgsConstructor
class ShitterService {
    private final ShitterRepository shitterRepository;

    void addShitter(Shitter shitter) {
        shitterRepository.save(shitter);
    }

    void acceptShitter(Long id) {
        Shitter shitter = shitterRepository.findOne(id);
        long reputationCounter = shitter.getReputationCounter();
        shitter.setReputationCounter(reputationCounter + 1);
    }

    void rejectShitter(Long id) {
        Shitter shitter = shitterRepository.findOne(id);
        long reputationCounter = shitter.getReputationCounter();
        shitter.setReputationCounter(reputationCounter - 1);
    }
}
