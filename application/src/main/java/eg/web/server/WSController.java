package eg.web.server;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class WSController {

    private static final Logger LOGGER = LoggerFactory.getLogger (WSController.class);

    @GetMapping ("")
    public Mono <List <String>> rootJsonMono () {
        List <String> endPoints = List.of ("/");
        LOGGER.atInfo ().log ("get end points: {}", endPoints);
        return Mono.just (endPoints);
    }

}
