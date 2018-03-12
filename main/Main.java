package main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class Main {

    public static void main(String[] args) {
        Spider spider = new Spider();
        try {
            Document doc = Jsoup.connect("http://www.google.com/").get();
            Elements links = doc.getElementsByTag("a");
            for(Element link: links){
                String text = link.text();
                String href = link.attr("href");
                //System.out.println(text+": "+href);
                System.out.println(spider.transformLink(href));
            }
            String title = doc.title();
            System.out.println(title);
        }catch(Exception e) {
            e.printStackTrace();
        }

    }
}
