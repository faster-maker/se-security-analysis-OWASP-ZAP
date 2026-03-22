// 来源：org.zaproxy.zap.extension.ascan.ActiveScanManager

public class ActiveScanManager {

    public void scanUrl(String url, Context context) {

        List<AscanRule> rules = getRelevantRules(url, context);

        for (AscanRule rule : rules) {

            Map<String, List<String>> params = rule.getAttackParam();

            for (String param : params.keySet()) {
                for (String value : params.get(param)) {

                    String attackUrl = constructAttackUrl(url, param, value);

                    HttpMessage response = sendRequest(attackUrl);

                    if (isVulnerable(response)) {
                        raiseAlert();
                    }
                }
            }
        }
    }
}
