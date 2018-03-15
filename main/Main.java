package main;

public class Main {

    public static void main(String[] args) {
        Spider spider = new Spider();
        spider.createJson("https://www.google.com/");//must be full http address for url
    }
}
