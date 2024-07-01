package testing;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

public class ResourceReader {

    public static String resourceContent (final String resourceName) {
        String charsetName = "utf-8";
        URL url = Optional.ofNullable (ResourceReader.class.getClassLoader ().getResource (resourceName)).orElseThrow ();
        String resourcePathString = url.getFile ();
        try {return Files.readString (Paths.get (resourcePathString), Charset.forName (charsetName)).trim ();}
        catch (IOException e) {e.printStackTrace (); return "";}
    }

}
