package pl.wawcode.eiti.shitter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.wawcode.eiti.shitter.domain.ShitterFacade;

@Controller
@RequiredArgsConstructor
class ShitterController {
    private final ShitterFacade shitterFacade;

    @GetMapping(path = "shitter/accept")
    void acceptShitter(Long id) {
        shitterFacade.acceptShitter(id);
    }
}
