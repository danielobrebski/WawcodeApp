package pl.wawcode.eiti.shitter.domain;

import lombok.RequiredArgsConstructor;
import pl.wawcode.eiti.shitter.dtos.ViewPortRange;
import pl.wawcode.eiti.shitter.exceptions.AlreadyVotedException;

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

    void changeReputation(Long id, String remoteAddr, boolean positive) {
        Shitter shitter = shitterRepository.findOne(id);
        validateVoter(remoteAddr, shitter);
        changeReputation(shitter, positive);
        shitter.getVoters().add(Voter.builder().remoteAddr(remoteAddr).build());
        shitterRepository.save(shitter);
    }

    private void validateVoter(String remoteAddr, Shitter shitter) {
        if(shitter.getVoters().contains(remoteAddr)) {
            throw new AlreadyVotedException();
        }
    }

    private void changeReputation(Shitter shitter, boolean positive) {
        long newRep = positive ? shitter.getReputationCounter() + 1 : shitter.getReputationCounter() - 1;
        shitter.setReputationCounter(newRep);
    }

}
