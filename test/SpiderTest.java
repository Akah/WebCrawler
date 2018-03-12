package test;

import main.Spider;
import org.jsoup.Jsoup;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpiderTest {

    @Test
    public void crawl() {
    }

    @Test
    public void transformLink() {
        Spider spider = new Spider();
        assertEquals("www.google.com",spider.transformLink("www.google.com"));
        assertEquals("https://www.google.com/images",spider.transformLink("https://www.google.com/images"));
        assertEquals("www.google.com/images",spider.transformLink("//google.com/images"));
        assertEquals("www.google.com/images/#anchor",spider.transformLink("#anchor"));
        assertEquals("www.google.com/maps",spider.transformLink("../maps"));
    }
}