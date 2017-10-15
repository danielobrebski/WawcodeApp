package pl.wawcode.eiti.shitter.dtos;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import pl.wawcode.eiti.shitter.domain.ShitterLocation;

import javax.persistence.Embedded;
import java.io.File;
import java.time.LocalDateTime;

@Data
@Builder
public class ShitterOutDto {
    private Double latitude;
    private Double longitude;
    private Long id;
    private long reputationCounter;
    private LocalDateTime openingHour;
    private LocalDateTime closingHour;
    private byte[] image;
    private String description;
}
