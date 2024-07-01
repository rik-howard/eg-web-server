package eg.web.server;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WSApplicationNT {

    @Test void shouldEquateHostNames () throws IOException {
        // given; when; then
        String expected = Runtime
            .getRuntime ()
            .exec ("hostname")
            .inputReader (Charset.defaultCharset ())
            .readLine ();
        String actual = InetAddress
            .getLocalHost ()
            .getHostName ();
        assertEquals (expected, actual);
    }

}
