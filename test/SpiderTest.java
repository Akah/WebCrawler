package test;

import main.Spider;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpiderTest {

    @Test
    public void WWWReturnsFullAddress() {
        Spider spider = new Spider();
        assertEquals("www.google.com",spider.transformLink("www.google.com/images","www.google.com"));
    }

    @Test
    public void HttpsReturnsHttpsAddress() {
        Spider spider = new Spider();
        assertEquals("https://www.google.com/images",spider.transformLink("www.google.com/images","https://www.google.com/images"));
    }

    @Test
    public void DoubleSlashReturnsFullAddress() {
        Spider spider = new Spider();
        assertEquals("www.google.com/images",spider.transformLink("www.google.com/images","//google.com/images"));
    }

    @Test
    public void HashReturnsAnchorAddress() {
        Spider spider = new Spider();
        assertEquals("www.google.com/images#anchor",spider.transformLink("www.google.com/images","#anchor"));
    }

    @Test
    public void DotDotSlashReturnsFullAddress() {
        Spider spider = new Spider();
        assertEquals("www.google.com/",spider.transformLink("www.google.com/images","../"));
    }

    @Test
    public void EmptyReturnsNull(){
        Spider spider = new Spider();
        assertEquals(null,spider.transformLink("www.google.com",""));
    }

    @Test
    public void NullSReturnsNull(){
        Spider spider = new Spider();
        assertEquals(null,spider.transformLink("www.google.com",null));
    }

}