package main;

import java.util.UUID;


public class Data {
    public String parent;
    public String text;
    public String link;
    public String id = UUID.randomUUID().toString();

    public Data(String text, String link, String parent){
        this.text   = text;
        this.link   = link;
        this.parent = parent;
    }

    public String getLink()   { return link; }
    public String getId()     { return id; }
    public String getParent() { return parent; }
    public String getText()   { return text; }
}
