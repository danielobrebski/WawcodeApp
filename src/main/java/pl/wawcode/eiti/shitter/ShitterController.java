package pl.wawcode.eiti.shitter;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.wawcode.eiti.shitter.dtos.ViewPortRange;
import pl.wawcode.eiti.shitter.domain.ShitterFacade;
import pl.wawcode.eiti.shitter.dtos.ShitterInDto;
import pl.wawcode.eiti.shitter.dtos.SubmissionShitterDto;
import pl.wawcode.eiti.shitter.dtos.ShitterOutDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/")
@CrossOrigin(origins = "http://0.0.0.0:8080")
class ShitterController {
    private final ShitterFacade shitterFacade;

    @PostMapping(value = "/shitter/getShittersFromLocation", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ShitterOutDto>> getShittersFromLocation(@RequestBody ViewPortRange viewPortRange) {
        return new ResponseEntity<>(shitterFacade.getShitters(viewPortRange), HttpStatus.OK);
    }

    @PostMapping(value = "/shitter/accept", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> acceptShitter(@RequestBody SubmissionShitterDto dto,
                                       HttpServletRequest request) {
        return Try.of(() -> shitterFacade.acceptShitter(dto.getShitterId(), request.getRemoteAddr()))
                .map(ResponseEntity::ok)
                .getOrElse(ResponseEntity.status(HttpStatus.FORBIDDEN).body(null));
    }

    @PostMapping(value = "/shitter/reject", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> rejectShitter(@RequestBody SubmissionShitterDto dto,
                                       HttpServletRequest request) {
        return Try.of(() -> shitterFacade.rejectShitter(dto.getShitterId(), request.getRemoteAddr()))
                .map(ResponseEntity::ok)
                .getOrElse(ResponseEntity.status(HttpStatus.FORBIDDEN).body(null));
    }

    @PostMapping(path = "/shitter/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> addShitter(@RequestBody ShitterInDto newShitter, @RequestParam("file") MultipartFile file) {
        shitterFacade.addShitter(newShitter, file);
        return ResponseEntity.ok(null);
    }
}
