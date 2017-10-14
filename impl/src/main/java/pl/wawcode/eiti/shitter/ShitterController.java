package pl.wawcode.eiti.shitter;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.wawcode.eiti.shitter.domain.ShitterFacade;
import pl.wawcode.eiti.shitter.dtos.ShitterInDto;
import pl.wawcode.eiti.shitter.dtos.SubmissionShitterDto;

@Controller
@RequiredArgsConstructor
class ShitterController {
    private final ShitterFacade shitterFacade;

    @PostMapping(value = "/shitter/accept", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> acceptShitter(@RequestBody SubmissionShitterDto dto) {
        shitterFacade.acceptShitter(dto.getShitterId());
        return ResponseEntity.ok(null);
    }

    @PostMapping(value = "/shitter/reject", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> rejectShitter(@RequestBody SubmissionShitterDto dto) {
        shitterFacade.rejectShitter(dto.getShitterId());
        return ResponseEntity.ok(null);
    }

    @PostMapping(path = "/shitter/add")
    ResponseEntity<Void> addShitter(@RequestBody ShitterInDto newShitter) {
        shitterFacade.addShitter(newShitter);
        return ResponseEntity.ok(null);
    }
}
