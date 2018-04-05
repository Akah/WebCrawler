import com.mongodb.*;

import java.util.List;

public class Database {
    private MongoClient mongoClient = new MongoClient();
    private DB web = mongoClient.getDB("web");
    private DBCollection pages = web.getCollection("pages");

    public void writeMain(List<String> queue){
        for(String link: queue) {
            System.out.println(link);
            BasicDBObject doc = new BasicDBObject().append("link",link);
            pages.insert(doc);
        }
    }

    public String returnLast(){
        BasicDBObject query = new BasicDBObject();
        DBCursor cursor = pages.find(query);
        cursor.sort(new BasicDBObject("_id",-1)).limit(1);
        return cursor.next().get("link").toString();
    }
}
