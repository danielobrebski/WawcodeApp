package pl.wawcode.eiti.shitter.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ShitterFacade {
    private final ShitterService shitterService;

    public void acceptShitter(Long id) {
        shitterService.acceptShitter(id);
    }
}
