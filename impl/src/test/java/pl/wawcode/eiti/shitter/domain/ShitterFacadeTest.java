package pl.wawcode.eiti.shitter.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.wawcode.eiti.shitter.dtos.ShitterInDto;
import pl.wawcode.eiti.shitter.dtos.ShitterOutDto;
import pl.wawcode.eiti.shitter.dtos.ViewPortRange;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShitterFacadeTest {

    @Autowired
    private ShitterFacade facade;

    @Test
    public void getShitters() throws Exception {
        facade.addShitter(ShitterInDto.builder().latitude(66d).longitude(66d).build());
        List<ShitterOutDto> shitterList = facade.getShitters(new ViewPortRange(new ShitterLocation(0d, 0d), new ShitterLocation(100d, 100d)));
        assertTrue(shitterList.size() == 5);
    }
}