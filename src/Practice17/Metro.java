package Practice17;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//import java.io.*;
//import java.net.MalformedURLException;
//import java.net.URL;
//class Line {
//    public String name, num;
//}
//
public class Metro {
//
//    static public String GetUrl(Element el){
//        String src = el.absUrl("src");
//        return src;
//    }
//
//    public static void main(String[] args) throws IOException {
//        new File(System.getProperty("user.dir") + "\\images").mkdir();
//        Document doc = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").get();
//        Elements line = null;
//        String def = "js-metro-line t-metrostation-list-header t-icon-metroln ln-";
//      //String[] lines = new String[17];
//        Line[] lines = new Line[17];
//        for (int i = 0; i<17; i++){
//
//            switch (i) {
//                case (16): {
//                    line = (doc.getElementsByClass(def + "D2"));
//                }
//                break;
//                case (15): {
//                    line = (doc.getElementsByClass(def + "D1"));
//                }
//                break;
//                case (14): {
//                    line = (doc.getElementsByClass(def + "15"));
//                }
//                break;
//                case (13): {
//                    line = (doc.getElementsByClass(def + "14"));
//                }
//                break;
//                case (12): {
//                    line = (doc.getElementsByClass(def + i));
//                }
//                break;
//                case (11): {
//                    line = (doc.getElementsByClass(def + "11A"));
//                }
//                break;
//                default:
//                    line = (doc.getElementsByClass(def + (i + 1)));
//
//                    break;
//            }
//
//         for (Element el : line) {
//           // lines[i] = (el.text());
//             lines[i].name = el.text()
//         }
//        }
//        for (int i = 0; i < lines.length; i++) {
//            System.out.println(lines[i]);
//        }
//
//
//
//    }
public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines]").maxBodySize(0).get();
        Elements objects = doc.select("span.js-metro-line.t-metrostation-list-header.t-icon-metroln");
    for (Element el : objects) {
        System.out.println(el.text());
        System.out.println(el.attr("data-line"));
    }
        objects = doc.select("div.js-metro-stations.t-metrostation-list-table");
    for (Element el : objects) {
       for (Element st : el.children()){
           System.out.println(st.text() + " " + el.attr("data-line"));
       }
       System.out.println();
    }
}

}
