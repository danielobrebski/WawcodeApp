package pl.wawcode.eiti.shitter.dtos;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
@Builder
public class ShitterInDto {
    private Double latitude;
    private Double longitude;
    private LocalDateTime openingHour;
    private LocalDateTime closingHour;
    private MultipartFile image;
    private String description;
}
