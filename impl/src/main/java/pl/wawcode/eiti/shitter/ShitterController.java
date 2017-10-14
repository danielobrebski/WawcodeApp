package pl.wawcode.eiti.shitter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.wawcode.eiti.shitter.domain.ShitterFacade;
import pl.wawcode.eiti.shitter.dtos.ShitterInDto;

@Controller
@RequiredArgsConstructor
class ShitterController {
    private final ShitterFacade shitterFacade;

    @GetMapping(path = "shitter/accept")
    void acceptShitter(Long id) {
        shitterFacade.acceptShitter(id);
    }

    @PostMapping(path = "shitter/add")
    void addShitter(@RequestBody ShitterInDto newShitter) {
        shitterFacade.addShitter(newShitter);
    }
}
