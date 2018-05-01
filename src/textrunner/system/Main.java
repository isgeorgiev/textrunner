package textrunner.system;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class Main {
    public static String[] links = {"https://en.wikipedia.org/wiki/Mark_Zuckerberg", "https://en.wikipedia.org/wiki/Bill_Gates",
            "https://en.wikipedia.org/wiki/Steve_Jobs","https://en.wikipedia.org/wiki/Jeff_Bezos", "https://en.wikipedia.org/wiki/Tim_Cook",
            "https://en.wikipedia.org/wiki/Warren_Buffett","https://en.wikipedia.org/wiki/Berkshire_Hathaway",
            "https://en.wikipedia.org/wiki/Elon_Musk", "https://en.wikipedia.org/wiki/Larry_Page", "https://en.wikipedia.org/wiki/Sergey_Brin"};


    public static void main(String[] args) throws IOException{
//        Elements[] texts = new Elements[10];
//        int counter = 0;
//        for (String link: links){
//            Document doc = Jsoup.connect(link).get();
//            texts[counter] = doc.select("body");
//            counter++;
//
//      }

        TextReader test = new TextReader(links[2]);
        String[] sentences = test.split();
        System.out.println(test.text);
        for(String s:sentences){
            System.out.println(s);
        }
        //
//        System.out.println(test.html2text());
//        for (Element pars : text) {
//            System.out.println(pars.text());
//        }
    }
}

