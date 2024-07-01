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
    private final WSService wsService;
    private final String colour;

    @Autowired public WSController (final WSService wsService, final String colour) {
        this.wsService = wsService;
        this.colour = colour;
    }

    @GetMapping ("")
    public Mono <List <String>> rootJsonMono () {
        List <String> endPoints = wsService.endPoints ();
        LOGGER.atInfo ().log ("get end points: {}", endPoints);
        return Mono.just (endPoints);
    }

    @GetMapping ("/hostname")
    public Mono <String> hostnameJsonMono (final @RequestHeader ("Request-Id") String requestId) {
        String hostname = wsService.hostname ();
        LOGGER.atInfo ().log ("get requestId: {}; hostname: {}; colour: {}", requestId, hostname, colour);
        return Mono.just (Template.hostnameJson (hostname, requestId, colour));
    }

}
