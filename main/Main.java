package main;

import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        Spider spider = new Spider("https://www.duckduckgo.com/");//must be full http(s) address for url with / at end
        spider.crawl();
    }
}
