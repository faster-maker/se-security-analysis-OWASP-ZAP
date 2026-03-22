// 自定义整理：不安全Cookie检测示例

public class InsecureCookiePassiveScanner implements PassiveScanner {

    @Override
    public void scan(HttpMessage message) {

        String cookie = message.getResponseHeader().getHeader("Set-Cookie");

        if (cookie != null && !cookie.contains("Secure")) {

            Alert alert = new Alert(
                "Insecure Cookie",
                "Cookie缺少Secure标志"
            );

            raiseAlert(alert);
        }
    }
}
