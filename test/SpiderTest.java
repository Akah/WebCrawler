package test;

import main.Spider;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpiderTest {

    @Test
    public void WWWReturnsFullAddress() {
        Spider spider = new Spider();
        assertEquals("www.google.com",spider.transformLink("www.google.com"));
    }

    @Test
    public void HttpsReturnsHttpsAddress() {
        Spider spider = new Spider();
        assertEquals("https://www.google.com/images",spider.transformLink("https://www.google.com/images"));
    }

    @Test
    public void DoubleSlashReturnsFullAddress() {
        Spider spider = new Spider();
        assertEquals("www.google.com/images",spider.transformLink("//google.com/images"));
    }

    @Test
    public void HashReturnsAnchorAddress() {
        Spider spider = new Spider();
        assertEquals("www.google.com/images/#anchor",spider.transformLink("#anchor"));
    }

    @Test
    public void DotDotSlashReturnsFullAddress() {
        Spider spider = new Spider();
        assertEquals("www.google.com/images/#anchor",spider.transformLink("#anchor"));
    }
}