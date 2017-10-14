package pl.wawcode.eiti.shitter.domain;

import lombok.RequiredArgsConstructor;
import pl.wawcode.eiti.shitter.dtos.ViewPortRange;

import java.util.List;

@RequiredArgsConstructor
class ShitterService {

    private final ShitterRepository shitterRepository;


    List<Shitter> getShitters(ViewPortRange viewPortRange) {
        List<Shitter> shitterList = shitterRepository.findByLocationBetween(
                viewPortRange.getDownLeftLatitudeLongitude(),
                viewPortRange.getUpRightLatitudeLongitude()
        );
        return shitterList;
    }

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
