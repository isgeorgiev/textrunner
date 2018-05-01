package textrunner.system;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class TextReader {
    String text;

    TextReader(String link) throws IOException{
        Document doc = Jsoup.connect(link).get();
        this.text = doc.select("body").text();
    }

    public String html2text(){
        return this.text;
    }

    public String[] split(){
        String[] sentences = this.text.split("\\.");
        return sentences;
    }
}
