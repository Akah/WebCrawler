package main;

import java.util.UUID;


public class DataValue {
    public String parent;
    public String text;
    public String link;
    public String id = UUID.randomUUID().toString();

    public DataValue(String text, String link, String parent){
        this.text   = text;
        this.link   = link;
        this.parent = parent;
    }

    public String getlink() { return link; }

    public String getId() { return id; }

    public String getText() { return text; }

    public String getParent() { return parent; }

}
