package eg.web.server;

public class Template {

    private Template () {}

    public static String hostnameJson (final String hostname, final String requestId, final String colour) {
        final String template = """
            {
                "hostname": "%s",
                "requestId": "%s",
                "colour": "%s"
            }""";
        return String.format (template, hostname, requestId, colour);
    }

}
