package pl.wawcode.eiti.shitter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import pl.wawcode.eiti.shitter.domain.ShitterFacade;

@Controller
@RequiredArgsConstructor
class ShitterController {
    private final ShitterFacade shitterFacade;
}
