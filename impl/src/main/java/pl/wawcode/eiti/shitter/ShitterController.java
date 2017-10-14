package pl.wawcode.eiti.shitter;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.wawcode.eiti.shitter.dtos.ViewPortRange;
import pl.wawcode.eiti.shitter.domain.ShitterFacade;
import pl.wawcode.eiti.shitter.dtos.ShitterInDto;
import pl.wawcode.eiti.shitter.dtos.SubmissionShitterDto;
import pl.wawcode.eiti.shitter.dtos.ShitterOutDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
class ShitterController {
    private final ShitterFacade shitterFacade;


    @GetMapping("/shitter/getShitters")
    List<ShitterOutDto> getShittersFromLocation(@RequestParam(value="viewPortRange") ViewPortRange viewPortRange) {
        return shitterFacade.getShitters(viewPortRange);
    }

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
