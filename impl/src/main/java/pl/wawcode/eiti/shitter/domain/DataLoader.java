package pl.wawcode.eiti.shitter.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
class DataLoader implements ApplicationRunner {

    private final ShitterRepository shitterRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (shitterRepository.findAll().iterator().hasNext()) {

        }

        log.info("XD");
    }
}
