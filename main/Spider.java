package main;

import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.LinkedList;
import java.util.List;

public class Spider {
    private List<Object> urls = new LinkedList<Object>();
    private String origin;

    public void crawl(String startUrl, String currentUrl){
        try {
            Document doc = Jsoup.connect(currentUrl).get();
            Elements links = doc.getElementsByTag("a");
            String title = doc.title();
            System.out.println("Page: "+title);
            for(Element link: links){
                String text = link.text();
                String href = link.attr("href");
                DataValue data = new DataValue(text,transformLink(currentUrl,href),currentUrl);
                urls.add(data);
                /*
                System.out.println("--------------------------------");
                System.out.println(data.getlink());
                System.out.println(data.getId());
                System.out.println(data.getText());
                System.out.println(data.getParent());*/
            }

            printLink((DataValue)urls.get(0));
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void printLink(DataValue data){
        System.out.println(data.getlink());
    }
    public String transformLink(String currentUrl,String link) {
        if (link == null || link.equals("")) {
            return null;
        }
        String url = "";
        if (link.startsWith("#")) {
            url = currentUrl + link;
        } else if (link.startsWith("/")) {
            if (link.startsWith("/")) {
                //url = link.replaceFirst(\//);
            } else {
                url = currentUrl + link;
            }
        } else if (link.startsWith("www") || link.startsWith("http")) {
            url = link;
        } else {
            return null;
        }
        return url;
    }
}
