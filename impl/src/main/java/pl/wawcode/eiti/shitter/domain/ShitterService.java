package pl.wawcode.eiti.shitter.domain;

import lombok.RequiredArgsConstructor;
import pl.wawcode.eiti.shitter.dtos.ViewPortRange;

import java.util.List;

@RequiredArgsConstructor
class ShitterService {

    private static final long MINIMUM_REPUTATION = 0l;

    private final ShitterRepository shitterRepository;


    List<Shitter> getShitters(ViewPortRange viewPortRange) {
        List<Shitter> shitterList = shitterRepository.findByLocationBetween(
                viewPortRange.getDownLeftLatitudeLongitude(),
                viewPortRange.getUpRightLatitudeLongitude());
        return shitterList;
    }

    void addShitter(Shitter shitter) {
        shitterRepository.save(shitter);
    }

    void acceptShitter(Long id) {
        Shitter shitter = shitterRepository.findOne(id);
        long reputationCounter = shitter.getReputationCounter();
        shitter.setReputationCounter(reputationCounter + 1);
        shitterRepository.save(shitter);
    }

    void rejectShitter(Long id) {
        Shitter shitter = shitterRepository.findOne(id);
        long reputationCounter = shitter.getReputationCounter();
        shitter.setReputationCounter(reputationCounter - 1);
        shitterRepository.save(shitter);
    }
}
