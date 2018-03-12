package main;

public class Spider {
    public String currentUrl = "www.google.com";
    public void crawl(){ }

    public String transformLink(String link){
        String url="";
        // anchor
        if (link.substring(0,1)=="#") {
            url = currentUrl+link;
        }
        // single and double slash
        else if (link.substring(0,1)=="/"){
            if(link.substring(1,2)=="/"){

            } else {

            }
        }
        else if (link.substring(0,3)=="www" || link.substring(0,5)=="http"){
            url = link;
        }
        // ../
        // just chars
        return url;
   }
}
