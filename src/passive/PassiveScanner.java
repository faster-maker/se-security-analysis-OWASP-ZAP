// 来源：org.zaproxy.zap.extension.pscan.PassiveScanner

public interface PassiveScanner {

    void scan(HttpMessage message);

    Set<Integer> getAlerts();

    String getName();
}
