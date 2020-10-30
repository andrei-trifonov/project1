package Practice13;

import java.util.ArrayList;

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
    ADD("Sample text");
    ADD("Activity1");
    ADD ("Activity2");
    ADD(2, "Activity3");
    DELETE (4);
    EDIT (1, "Activity4");
    LIST();
    }
}