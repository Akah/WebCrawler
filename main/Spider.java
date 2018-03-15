package main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import main.DataValue;
public class Spider {
    public void createJson(String url){
        List<Object> objects = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(url).get();
            String title = doc.title();
            Elements links = doc.getElementsByTag("a");
            for(Element link: links) {
                String text = link.text();
                String href = link.attr("href");
                DataValue data = new DataValue(text,href,url);
                objects.add(data);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }

        //System.out.print("[");
        for (Object object: objects) {
            System.out.println(object.get);
        }
        //System.out.print("]");
    }

    public String correctLink(String link, String currentUrl){
        //check if string is valid
        if(link.equals(null) || link.equals("") || link.contains(" ")){
            return null;
        }
        String url="";
        if (link.startsWith("#")) {
            url = currentUrl+link;
        }
        else if (link.startsWith("/")){
            if(link.charAt(1)=='/'){
                url = link.replaceFirst("//","www.");
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
