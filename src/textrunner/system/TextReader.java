package textrunner.system;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.coref.data.CorefChain;

import java.util.*;
import java.io.IOException;


public class TextReader {
    Elements document;
    String text;

    TextReader(String link) throws IOException{
        Document doc = Jsoup.connect(link).get();
        this.document = doc.select("body");
    }



    public String html2text(){
        this.text = this.document.text();
        return text;

    }





}
