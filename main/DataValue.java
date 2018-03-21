package main;

import java.util.UUID;


public class DataValue {
    public String title;
    public String link;
    public String id = UUID.randomUUID().toString();

    public DataValue(String link, String title){
        this.title = title;
        this.link  = link;
    }

    public String getLink()   { return link; }
    public String getId()     { return id; }
    public String getTitle()  { return title; }
}
