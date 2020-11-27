package Practice17;

import com.google.gson.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.*;
class AllMap{
    public ArrayList lines;
    public Map stations;

}
class Lines{
    public String  number, name;
    public Lines (String number, String name){
        this.name = name;
        this.number = number;
    }
}
public class Metro {

public static void main(String[] args) throws IOException {

        AllMap object = new AllMap();
     ArrayList lines= new ArrayList();

    Map<String, List> stations = new HashMap<>();
        Document doc = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines]").maxBodySize(0).get();
        Elements objects = doc.select("span.js-metro-line.t-metrostation-list-header.t-icon-metroln");

    for (Element el : objects) {
        lines.add(new Lines(el.attr("data-line"),el.text()));
    }
    object.lines = lines;

    objects = doc.select("div.js-metro-stations.t-metrostation-list-table");
    for (Element el : objects) {
        List list = new ArrayList();
       for (Element st : el.children()){
           list.add(st.text());
       }
       stations.put(el.attr("data-line"), list);
    }
   object.stations= stations;
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();
    String str = gson.toJson(object);
    File file = new File("File.json");
    try(FileOutputStream stream = new FileOutputStream(file)) {
        file.createNewFile();
        stream.write(str.getBytes());
    }catch (IOException e){
        System.out.println("can't write to file");
    }
    str = "";
    try(FileInputStream stream = new FileInputStream(file)) {
        while (true) {
            int code = stream.read();

            if (code < 0)
                break;

            char ch = (char) code;
            str+=ch;}
        AllMap object2 = new Gson().fromJson(str, AllMap.class);

        Iterator<Map.Entry<String, List>> it = object2.stations.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, List> pair = it.next();
           System.out.println(  "Ветвь: " + pair.getKey() + " Станций: "+ pair.getValue().size() );
        }


    }catch (IOException e){
        System.out.println("can't write to file");
    }




}

}
