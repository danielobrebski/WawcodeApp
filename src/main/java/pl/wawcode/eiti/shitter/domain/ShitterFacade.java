package pl.wawcode.eiti.shitter.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import pl.wawcode.eiti.shitter.dtos.ShitterInDto;
import pl.wawcode.eiti.shitter.dtos.ViewPortRange;
import pl.wawcode.eiti.shitter.dtos.ShitterOutDto;

import javax.transaction.RollbackException;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ShitterFacade {
    private final ShitterService shitterService;

    @Transactional(rollbackOn = RuntimeException.class)
    public void addShitter(ShitterInDto shitter, MultipartFile file) {
        try {
            shitterService.addShitter(
                Shitter
                    .builder()
                        .location(new ShitterLocation(shitter.getLatitude(), shitter.getLongitude()))
                        .openingHour(shitter.getOpeningHour())
                        .closingHour(shitter.getClosingHour())
                        .description(shitter.getDescription())
                        .image(file != null ? file.getBytes() : null)
                    .build()
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional(rollbackOn = RuntimeException.class)
    public Void acceptShitter(Long id, String remoteAddr) {
        shitterService.changeReputation(id, remoteAddr, true);
        return null;
    }

    @Transactional(rollbackOn = RuntimeException.class)
    public Void rejectShitter(Long id, String remoteAddr) {
        shitterService.changeReputation(id, remoteAddr, false);
        return null;
    }

    @Transactional(rollbackOn = RuntimeException.class)
    public List<ShitterOutDto> getShitters(ViewPortRange viewPortRange) {
        return shitterService.getShitters(viewPortRange)
            .stream()
            .map(shitter -> ShitterOutDto
                .builder()
                    .id(shitter.getId())
                    .longitude(shitter.getLocation().getLongitude())
                    .latitude(shitter.getLocation().getLatitude())
                    .reputationCounter(shitter.getReputationCounter())
                    .openingHour(shitter.getOpeningHour())
                    .closingHour(shitter.getClosingHour())
                    .description(shitter.getDescription())
                    .image(shitter.getImage())
                    .build()
            )
            .collect(Collectors.toList());
    }
}