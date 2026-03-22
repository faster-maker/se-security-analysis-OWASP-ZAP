// 来源：org.zaproxy.zap.extension.spider.Spider

public class Spider {

    public void scan(String url) {

        Queue<String> queue = new LinkedList<>();
        queue.add(url);

        while (!queue.isEmpty()) {

            String current = queue.poll();

            HttpMessage response = sendRequest(current);

            List<String> links = parseLinks(response);

            for (String link : links) {
                queue.add(link);
            }
        }
    }
}
