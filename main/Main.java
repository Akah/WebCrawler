package main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class Main {

    public static void main(String[] args) {
        Spider spider = new Spider();
        String startPoint = "https://www.google.com/";

        spider.crawl(startPoint,startPoint);

    }
}
