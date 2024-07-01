package eg.web.server;

public class Template {

    private Template () {}

    public static String hostnameJson (final String hostname, final String requestId) {
        final String template = """
            {
                "hostname": "%s",
                "requestId": "%s"
            }""";
        return String.format (template, hostname, requestId);
    }

}
