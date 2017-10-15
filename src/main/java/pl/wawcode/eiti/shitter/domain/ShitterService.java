package pl.wawcode.eiti.shitter.domain;

import lombok.RequiredArgsConstructor;
import pl.wawcode.eiti.shitter.dtos.ViewPortRange;
import pl.wawcode.eiti.shitter.exceptions.AlreadyVotedException;

import java.awt.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
class ShitterService {

    private static final long MINIMUM_REPUTATION = 0l;
    private static final long VOTING_INTERVAL = 5000l;


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
        shitterRepository.save(shitter);
        shitter.getVoters().add(Voter.builder()
                .remoteAddr(remoteAddr)
                .timestamp(LocalDateTime.now())
                .build());
    }

    private void validateVoter(String remoteAddr, Shitter shitter) {
        if(shitter.getVoters().size() != 0) {
            Timestamp lastVotingDate = Timestamp.valueOf(findLastVotingDate(remoteAddr, shitter));
            Timestamp now = Timestamp.valueOf(LocalDateTime.now());

            if (now.getTime() - lastVotingDate.getTime() < 5000) {
                throw new AlreadyVotedException();
            }
        }
    }

    private LocalDateTime findLastVotingDate(String remoteAddr, Shitter shitter) {
        return shitter.getVoters().stream()
                .filter(voter -> voter.getRemoteAddr().equals(remoteAddr))
                .sorted(Comparator.comparing(Voter::getTimestamp).reversed())
                .findFirst()
                .orElseThrow(AlreadyVotedException::new)
                .getTimestamp();
    }

    private void changeReputation(Shitter shitter, boolean positive) {
        long newRep = positive ? shitter.getReputationCounter() + 1 : shitter.getReputationCounter() - 1;
        shitter.setReputationCounter(newRep);
    }

}
