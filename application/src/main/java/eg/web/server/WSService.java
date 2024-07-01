package eg.web.server;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class WSService {

    private static final String HOSTNAME;

    static {
        try {HOSTNAME = InetAddress.getLocalHost ().getHostName ();}
        catch (UnknownHostException e) {throw new RuntimeException (e);}
    }

    public List <String> endPoints () {
        return List.of ("/", "/hostname");
    }

    public String hostname () {
        return HOSTNAME;
    }

}
