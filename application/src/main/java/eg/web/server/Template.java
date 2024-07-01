package eg.web.server;

public class Template {

    private Template () {}

    public static String hostnameJson (final String hostname) {
        final String template = """
            {
                "hostname": "%s"
            }""";
        return String.format (template, hostname);
    }

}
