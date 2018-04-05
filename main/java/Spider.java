import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Spider {
    public static LinkedList<String> queue = new LinkedList<String>();
    public Spider(String startPoint){ queue.add(startPoint); }

    public void crawl() {
        int limit = -1;
        long start = System.currentTimeMillis();
        int counter = 0;
        Database db = new Database();
        while (!queue.isEmpty()) {
            String url = queue.getFirst();
            if(url!="") {
                try {
                    Document doc = Jsoup.connect(url).get();
                    Elements links = doc.getElementsByTag("a");
                    for (Element link : links) {
                        String href = link.attr("abs:href");
                        if(queue.indexOf(href)==-1){//if not in list
                            queue.add(href);
                            if(queue.size()% 1000 == 0){
                                System.out.println("writing to db");
                                List<String> tail = queue.subList(Math.max(queue.size() - 1000, 0), queue.size());
                                db.writeMain(tail);
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                counter++;
                System.out.println(queue.size());
            }
            queue.pop();

            //if(counter > limit) break;
        }
        System.out.println("queue size: "+queue.size());
        long end = System.currentTimeMillis();
        float secs = (end-start)/1000;
        System.out.println(secs+" seconds");
        System.out.println((float)((end-start)/1000.00)/60+" minutes");
        System.out.println((float)limit/secs+" file/second");
    }
}
