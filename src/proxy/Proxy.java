// 来源：org.parosproxy.paros.core.proxy.Proxy

public class Proxy {

    public void start(int port) {
        httpServer = new HttpServer();
        httpServer.bind(port, "0.0.0.0");
        httpServer.start();
    }

    public HttpMessage handleRequest(HttpMessage request) {

        if (!checkAccess(request)) {
            return null;
        }

        spiderMessage(request);

        for (PassiveScanner scanner : passiveScanners) {
            scanner.scan(request);
        }

        return forwardRequest(request);
    }
}
