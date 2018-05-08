package textrunner.system;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Main {
    public static String[] links = {"https://en.wikipedia.org/wiki/Mark_Zuckerberg"};

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
            text  = text2add.replaceAll("[^\\x00-\\x7F]", "");
            //text = text + "\n" + text2add;
        }
//        String text = "The Evolution of Web Development for Mobile Devices\n" +
//                "Building Web sites that perform well on mobile devices remains a challenge.\n" +
//                "\n" +
//                "Nicholas C. Zakas\n" +
//                "\n" +
//                "The biggest change in Web development over the past few years has been the remarkable rise of mobile computing. Mobile phones used to be extremely limited devices that were best used for making phone calls and sending short text messages. Today's mobile phones are more powerful than the computers that took Apollo 11 to the moon,10 with the ability to send data to and from nearly anywhere. Combine that with 3G and 4G networks for data transfer, and now using the Internet while on the go is faster than my first Internet connection, which featured AOL and a 14.4-kbps dialup modem.\n" +
//                "\n" +
//                "Yet despite these powerful advances in mobile computing, the experience of Web browsing on a mobile device is often frustrating. The iPhone opened up the \"real\" Internet to smartphone users. This was important because developers no longer had to write mobile-specific interfaces in custom languages such as WAP (Wireless Application Protocol). Instead, all existing Web sites and applications worked perfectly on the iPhone. At least that was the idea.\n" +
//                "\n" +
//                "With the fast iPhone and a 3G connection, one would expect a mobile Internet experience to be pretty snappy. However, the Web developed during a period when the bandwidth available to desktops increased each year. That meant Web sites and applications started to get larger, using more resources such as CSS (Cascading Style Sheets), JavaScript, images, and video. All of this was to provide a better experience on the only Internet that many people had: a wired connection going into the home or office.\n" +
//                "\n" +
//                "By using mobile devices to access that same Internet, however, users once again experienced a slower Web. Although cellular connections have continued to improve over the years, they are still nowhere near as fast as wired connections. Further, although today's smartphones are quite powerful, they still pale in comparison with the average desktop computer. Therefore, making the Internet fast for mobile devices is a strange problem. On the one hand, it's a lot like Web development in 1996 when everyone had slow connections. On the other hand, mobile devices today are much more powerful than computers were in 1996.\n" +
//                "\n" +
//                "The Latency Problem\n" +
//                "One of the biggest issues for mobile Web performance is latency—the delay experienced between request and response. Any given Internet connection is capable of transferring a certain amount of data within a specified amount of time, which is called bandwidth. Latency is what prevents users from receiving that optimal bandwidth even though their connections are theoretically capable of handling it.\n" +
//                "\n" +
//                "Wired Latency\n" +
//                "Every Internet connection has some latency. Wired connections have much lower latency because there's less to get in the way of the requested data. Wired connections allow data to travel more directly between points, so it is received fairly quickly. The biggest cause of latency here is the electrical resistance of the wire material. That's usually negligible unless the wire has been damaged. Otherwise, the latency of a wired connection remains fairly stable over time.\n" +
//                "\n" +
//                "When the latency of a wired network changes unexpectedly, the source could be network congestion. If you have ever arrived home in the evening and found your Internet connection slower than it was in the morning, it's probably because everyone in your neighborhood is hopping on the Internet at the same time. It could also be that several people in your household are on the Internet at the same time using a lot of bandwidth (streaming Netflix, surfing the Web, using FaceTime, etc.). Network congestion is always a consideration when latency is high, regardless of the network type.\n" +
//                "\n" +
//                "Wireless Latency\n" +
//                "Wireless Internet connections are quite different from their wired counterparts. Whether the connection is 3G, 4G, or Wi-Fi, sending and receiving data through the air introduces a variable amount of latency. The air itself not only causes resistance, but also provides an open space for other sources of interference. Radios, microwaves, walls, and any number of other physical or electromagnetic barriers can adversely impact the effective bandwidth.\n" +
//                "\n" +
//                "Tom Hughes-Croucher ran a simulation to determine the degree to which latency affects the throughput of a connection.2 By introducing just 50 ms of latency, he found that the number of requests that could be completed in 300 seconds was cut by nearly 67 percent. At 300 ms of latency, the number of requests was decreased by almost 90 percent. What did he use to affect the latency in his simulation? A simple microwave oven. Now imagine all of the interference produced by the electronics that surround you every day.\n" +
//                "\n" +
//                "The number of requests completed is very important because a typical Web page makes dozens of requests while loading. Visiting a Web site for the first time triggers two requests in sequence right away. The first is a DNS (Domain Name System) request to look up the domain name that the user entered. The response to that request contains the IP address for the domain. Then an HTTP request is sent to that IP address to get the HTML for the page. Of course, the page will typically instruct the browser to download more resources, which means more DNS requests and HTTP requests before the page is fully usable. That can happen fairly quickly with a wired connection, but a wireless connection such as the one on a smartphone introduces a lot of latency.\n" +
//                "\n" +
//                "The request first has to go from the phone to the nearest cellular tower. That request travels through the air where it is subject to a large degree of interference. Once it arrives at the cell tower, the request is routed to a mobile company server that uses a GPRS (General Packet Radio Service). For 3G, this is a GGSN (Gateway GPRS Support Node) that acts as an intermediary between the user and the Internet (see figure 1). The GGSN assigns IP addresses, filters packets, and generally acts as a gateway to the real Internet. The GGSN then sends the request to the appropriate location (DNS, HTTP, or other), and the response has to come all the way back from the Internet to the GGSN to the cell tower and finally to the phone. All of that back and forth creates a lot of latency in the system.";
        CoreDocument documentbody = new CoreDocument(text);
        pipeline.annotate(documentbody);

        List<CoreSentence> sentences = documentbody.sentences();

        System.out.println(sentences.get(0).text());
        /*
        for(CoreSentence sentence:sentences){
            //getting sentences
            System.out.println(sentence.text());
        }*/


    }
}

