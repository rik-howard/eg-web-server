package eg.web.server;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WSServiceUT {

    WSService subject;

    @BeforeEach void setUp () {
        subject = new WSService ();
    }

    @Test void shouldReturnHostname () throws IOException {
        // given; when
        String actual = subject.hostname ();
        // then
        String expected = Runtime
            .getRuntime ()
            .exec ("hostname")
            .inputReader (Charset.defaultCharset ())
            .readLine ();
        assertEquals (expected, actual);
    }

    @Test void shouldReturnEPs () {
        // given; when
        List <String> actual = subject.endPoints ();
        // then
        List <String> expected = List.of ("/", "/hostname");
        assertEquals (expected, actual);
    }

}
