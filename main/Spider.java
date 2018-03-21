package main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;

public class Spider {
    private LinkedList<String> queue = new LinkedList<>();
    public Spider(String startPoint){ queue.add(startPoint); }

    public void crawl() {
        int limit = 100;
        long start = System.currentTimeMillis();
        int counter = 0;
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
                        }

                    }
                    //createJson(doc, url);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                counter++;
            }
            queue.pop();
            System.out.println(counter);
            if(counter == limit) break;
        }
        System.out.println("queue size: "+queue.size());
        if(queue.size()<=50) {
            for (String link : queue) {
                System.out.println(link);
            }
        }
        long end = System.currentTimeMillis();
        float secs = (end-start)/1000;
        System.out.println(secs+" seconds");
        System.out.println((float)((end-start)/1000.00)/60+" minutes");
        System.out.println((float)limit/secs+" file/second");
    }

    private void createJson (Document doc,String url) {
        String title = doc.title();
        DataValue data = new DataValue(url, title);
        //post to database
    }

    private void printOut (DataValue object ){
        System.out.println(object.getId());
        System.out.println(object.getTitle());
        System.out.println(object.getLink());
        System.out.println("-----------------------------------------------------------");
        //System.out.println("\n"+objects.size()+" objects found");
    }

    private String correctLink (String link, String currentUrl) {
        //check if string is valid
        if(link.equals(null) || link.equals("") || link.contains(" ")){
            return null;
        }
        String url="";
        if (link.startsWith("#")) {
            url = currentUrl+link;
        }
        else if (link.startsWith("/")){
            if(link.startsWith("//")){
                url = link.replaceFirst("//","");//this requires attention later
            } else {
                url = currentUrl+link;
;           }
        }
        else if (link.startsWith("../")){
            url = currentUrl.split("\\/")[0];
        }
        else if (link.startsWith("www") || link.startsWith("http")){
            url = link;
        }
        else{
            url = link;
        }
        return url;
   }
}
