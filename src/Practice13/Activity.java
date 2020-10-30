package Practice13;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Activity {
    public String name;
    Activity(String name){
        this.name = name;
    }
}
class Start{
    static ArrayList<Activity> list = new ArrayList();
    static void LIST(){
        for(int i=0;i< list.size();i++){
            System.out.println((i+1) + " " + list.get(i).name);
        }
    }
    static void ADD(String text){
        list.add(new Activity(text));
    }
    static void ADD(int pos, String text){
        list.add(pos-1, new Activity(text));
    }
    static void EDIT(int pos, String text){
        list.get(pos-1).name = text;
    }
    static void DELETE (int pos){
        list.remove(pos-1);
    }
    
    public static void main(String[] args) {
        while (true){
            Scanner in = new Scanner(System.in);
            String text = in.nextLine();

            if ( text.contains("ADD")){
                if (text.charAt(4)>47 && text.charAt(5)<58){
                    String tmp="";
                    String tmpActivity="";
                    for (int i =4; i<text.length(); i++){
                        if (text.charAt(i)==' '){
                            tmpActivity = text.substring(i+1);
                            break;
                        }
                        tmp += text.charAt(i);
                    }
                    ADD (Integer.parseInt(tmp), tmpActivity);

                }
                else
                {
                    ADD (text.substring(4));
                }
            }
            if (text.contains("LIST")){
                LIST();
            }
            if (text.contains("DELETE")){
                DELETE (Integer.parseInt(text.substring(7,8)));
            }
            if (text.contains("EDIT")){
                String tmp="";
                String tmpActivity="";
                for (int i =5; i<text.length(); i++){
                    if (text.charAt(i)==' '){
                        tmpActivity = text.substring(i+1);
                        break;
                    }
                    tmp += text.charAt(i);
                }
                EDIT (Integer.parseInt(tmp), tmpActivity);
            }
        }

        }

    }
