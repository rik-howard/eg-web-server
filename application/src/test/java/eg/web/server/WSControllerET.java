package eg.web.server;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient.ResponseSpec;
import static testing.ResourceReader.resourceContent;

@SpringBootTest
@AutoConfigureWebTestClient
class WSControllerET {

    @Autowired WebTestClient webTestClient;

    @Test void shouldReceiveRootResponse () {
        // given; when
        ResponseSpec actual = webTestClient
            .get ()
            .uri ("/")
            .accept (MediaType.APPLICATION_JSON)
            .exchange ();
        // then
        String expected = resourceContent ("dto/root-response.json");
        actual
            .expectStatus ().isOk ()
            .expectHeader ().contentType (MediaType.APPLICATION_JSON)
            .expectBody ().json (expected)
        ;
    }

    @Test void shouldReceiveHostnameResponse () {
        // given
        String requestId = "000";
        // when
        ResponseSpec actual = webTestClient
            .get ()
            .uri ("/hostname")
            .accept (MediaType.APPLICATION_JSON)
            .header ("request-id", requestId)
            .exchange ();
        // then
        String expected = resourceContent ("dto/hostname-response.json");
        actual
            .expectStatus ().isOk ()
            .expectHeader ().contentType (MediaType.APPLICATION_JSON_UTF8)
            .expectBody ().json (expected)
        ;
    }

}
