package eg.web.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WSConfiguration {

    @Value ("${colour}") private String colour;

    @Bean (name = "colour") public String colour () {
        return colour;
    }


}
