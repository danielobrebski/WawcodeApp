package pl.wawcode.eiti.shitter;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.wawcode.eiti.shitter.domain.ShitterFacade;
import pl.wawcode.eiti.shitter.dtos.ShitterInDto;

import javax.validation.constraints.Null;

@Controller
@RequiredArgsConstructor
class ShitterController {
    private final ShitterFacade shitterFacade;

    @GetMapping(path = "shitter/accept")
    void acceptShitter(Long id) {
        shitterFacade.acceptShitter(id);
    }

    @PostMapping(path = "/shitter/add")
    ResponseEntity<Void> addShitter(@RequestBody ShitterInDto newShitter) {
        shitterFacade.addShitter(newShitter);
        return ResponseEntity.ok(null);
    }
}
