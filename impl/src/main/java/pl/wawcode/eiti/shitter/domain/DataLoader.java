package pl.wawcode.eiti.shitter.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
class DataLoader implements ApplicationRunner {

    private final ShitterRepository shitterRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (!shitterRepository.findAll().iterator().hasNext()) {
            shitterRepository.save(addInitialShitters());
        }
    }

    private List<Shitter> addInitialShitters() {
        List<Shitter> shitterList = new ArrayList<>(0);

        ShitterLocation shitterLocation = new ShitterLocation(52.255191, 21.037646);
        Shitter shitter = Shitter.builder().reputationCounter(-4).location(shitterLocation).build();
        shitterList.add(shitter);
        shitterLocation = new ShitterLocation(52.256465, 21.045628);
        shitter = Shitter.builder().reputationCounter(1).location(shitterLocation).build();
        shitterList.add(shitter);
        shitterLocation = new ShitterLocation(52.246465, 21.025528);
        shitter = Shitter.builder().reputationCounter(4).location(shitterLocation).build();
        shitterList.add(shitter);
        shitterLocation = new ShitterLocation(52.252215, 21.035628);
        shitter = Shitter.builder().reputationCounter(4).location(shitterLocation).build();
        shitterList.add(shitter);

        return shitterList;
    }
}
