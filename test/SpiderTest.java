package test;

import main.Spider;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpiderTest {

    @Test
    public void WWWReturnsFullAddress() {
        Spider spider = new Spider();
        assertEquals("www.google.com",spider.correctLink("www.google.com","www.google.com/images"));
    }

    @Test
    public void httpsReturnsHttpsAddress() {
        Spider spider = new Spider();
        assertEquals("https://www.google.com/images",spider.correctLink("https://www.google.com/images","www.google.com"));
    }

    @Test
    public void doubleSlashReturnsFullAddress() {
        Spider spider = new Spider();
        assertEquals("www.google.com/images",spider.correctLink("//google.com/images","www.google.com"));
    }

    @Test
    public void singleSlashReturnsAppendedAddress() {
        Spider spider = new Spider();
        assertEquals("www.google.com/images",spider.correctLink("/images","www.google.com"));
    }

    @Test
    public void hashReturnsAnchorAddress() {
        Spider spider = new Spider();
        assertEquals("www.google.com/images#anchor",spider.correctLink("#anchor","www.google.com/images"));
    }

    @Test
    public void dotDotSlashReturnsFullAddress() {
        Spider spider = new Spider();
        assertEquals("www.google.com",spider.correctLink("../","www.google.com/images"));
    }

    @Test
    public void emptyStringOrNullReturnsNull() {
        Spider spider = new Spider();
        assertEquals(null,spider.correctLink("","www.google.com"));
        //assertEquals(null,spider.getData(null,"www.google.com")); // Error here
    }
}