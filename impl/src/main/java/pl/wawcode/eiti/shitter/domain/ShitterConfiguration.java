package pl.wawcode.eiti.shitter.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ShitterConfiguration {

    @Bean
    public ShitterFacade shitterFacade(ShitterRepository shitterRepository){
        ShitterService shitterService = new ShitterService(shitterRepository);
        return new ShitterFacade(shitterService);
    }
}
