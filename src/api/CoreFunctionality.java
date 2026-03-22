// 来源：org.zaproxy.zap.api.CoreFunctionality

public class CoreFunctionality {

    public String handleApiRequest(String request) {

        String[] parts = request.split("/");

        String api = parts[0];
        String action = parts[1];

        ApiImplementor impl = getImplementor(api);

        return impl.execute(action);
    }
}
