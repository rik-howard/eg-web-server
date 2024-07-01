package eg.web.server;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import static org.mockito.Mockito.when;

class WSControllerUT {

    WSController subject;

    @BeforeEach void setUp () {
        subject = new WSController ();
    }

    @Test void shouldReturnEPs () {
        // given
        List <String> endPoints = List.of ("/");
        // when
        Mono <List <String>> actual = subject.rootJsonMono ();
        // then
        StepVerifier
            .create (actual)
            .expectNext (endPoints)
            .verifyComplete ();
    }

}
