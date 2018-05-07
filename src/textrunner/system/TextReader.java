package textrunner.system;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;


public class TextReader {
    Elements document;
    String text;

    TextReader(String link) throws IOException{

        Document doc = Jsoup.parse(new URL(link).openStream(), "UTF-8", link);
        this.document = doc.select("body");
    }

    public String html2text(){
        this.text = this.document.text();
        return text;

    }





}
