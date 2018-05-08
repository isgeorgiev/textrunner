package textrunner.system;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
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
        String text=null;
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse,depparse,coref,kbp,quote");
        // set a property for an annotator, in this case the coref annotator is being set to use the neural algorithm
        props.setProperty("coref.algorithm", "neural");
        // build pipeline
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        for(String link:links) {

            TextReader textInDocument = new TextReader(link);
            String text2add = textInDocument.html2text();
            text2add = text2add.replaceAll("[^\\x00-\\x7F]", "");
            text = text + "\n" + text2add;
        }
        CoreDocument documentbody = new CoreDocument(text);
        pipeline.annotate(documentbody);

        List<CoreSentence> sentences = documentbody.sentences();

        for(CoreSentence sentence:sentences){
            //getting sentences

            System.out.println(sentence.text());
        }


    }
}

