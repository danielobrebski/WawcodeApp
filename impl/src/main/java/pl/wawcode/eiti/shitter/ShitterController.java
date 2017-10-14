package pl.wawcode.eiti.shitter;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wawcode.eiti.shitter.dtos.ViewPortRange;
import pl.wawcode.eiti.shitter.domain.ShitterFacade;
import pl.wawcode.eiti.shitter.dtos.ShitterInDto;
import pl.wawcode.eiti.shitter.dtos.SubmissionShitterDto;
import pl.wawcode.eiti.shitter.dtos.ShitterOutDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/")
class ShitterController {
    private final ShitterFacade shitterFacade;


    @RequestMapping(value = "/shitter/getShittersFromLocation", method = RequestMethod.POST)
    ResponseEntity<List<ShitterOutDto>> getShittersFromLocation(@RequestBody ViewPortRange viewPortRange) {
        return new ResponseEntity<>(shitterFacade.getShitters(viewPortRange), HttpStatus.OK);
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
