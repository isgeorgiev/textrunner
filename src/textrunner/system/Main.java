package textrunner.system;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

import java.io.IOException;
import java.util.List;
import java.util.Properties;


public class Main {
    public static String[] links = {"https://en.wikipedia.org/wiki/Mark_Zuckerberg", "https://en.wikipedia.org/wiki/Bill_Gates",
            "https://en.wikipedia.org/wiki/Steve_Jobs","https://en.wikipedia.org/wiki/Jeff_Bezos", "https://en.wikipedia.org/wiki/Tim_Cook",
            "https://en.wikipedia.org/wiki/Warren_Buffett","https://en.wikipedia.org/wiki/Berkshire_Hathaway",
            "https://en.wikipedia.org/wiki/Elon_Musk", "https://en.wikipedia.org/wiki/Larry_Page", "https://en.wikipedia.org/wiki/Sergey_Brin"};




    public static void main(String[] args) throws IOException{



        for(String link:links) {

            TextReader textInDocument = new TextReader(link);
            String text = textInDocument.html2text();

            Properties props = new Properties();
            props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
            StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
            Annotation documentbody = new Annotation(text);

            pipeline.annotate(documentbody);

            System.out.println("saddasionasiasd");
            List<CoreMap> sentences = documentbody.get(CoreAnnotations.SentencesAnnotation.class);

            for(CoreMap sentence:sentences){
                //getting sentences

                System.out.println(sentence.toShorterString());
            }
        }

    }
}

