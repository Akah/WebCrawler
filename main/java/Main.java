import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        String startPoint;
        try {
            startPoint = new Database().returnLast();
        } catch (NoSuchElementException e){
            System.out.println(e);
            startPoint = "https://www.reddit.com/";
        }
        Spider spider = new Spider(startPoint);
        spider.crawl();
    }
}
