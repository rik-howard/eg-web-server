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
    @Mock WSService mockWSService;

    @BeforeEach void setUp () {
        MockitoAnnotations.openMocks (this);
        subject = new WSController (mockWSService);
    }

    @Test void shouldReturnEPs () {
        // given
        List <String> endPoints = List.of ("/", "/branch");
        // when
        when (mockWSService.endPoints ()).thenReturn (endPoints);
        Mono <List <String>> actual = subject.rootJsonMono ();
        // then
        StepVerifier
            .create (actual)
            .expectNext (endPoints)
            .verifyComplete ();
    }

    @Test void shouldReturnHostname () throws IOException {
        // given
        String hostname = "whatever";
        // when
        when (mockWSService.hostname ()).thenReturn (hostname);
        Mono <String> actual = subject.hostnameJsonMono ();
        // then
        String expected = Template.hostnameJson (hostname);
        StepVerifier
            .create (actual)
            .expectNext (expected)
            .verifyComplete ();
    }

}
