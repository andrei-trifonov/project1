package Practice13;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EMail{
    static TreeSet <String> email = new TreeSet();
    static void ADD(String text){
    Pattern check = Pattern.compile("([A-Za-z0-9]{1,}[\\\\.-]{0,1}[A-Za-z0-9]{1,})+@([A-Za-z0-9]{1,}[\\\\.-]{0,1}[A-Za-z0-9]{1,})+[\\\\.]{1}[a-z]{2,4}");
    Matcher matcherCheck = check.matcher(text);
    if (!matcherCheck.find()){
            System.out.println("Ошибка в адресе");
        }
    else {
        email.add(text);
    }
    }
    static void LIST(){
        Iterator<String> iterator = email.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
    public static void main(String[] args) {
        while(true){
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();

        if (text.charAt(0)=='A'&&text.charAt(1)=='D'&&text.charAt(2)=='D'){
            System.out.println("Добавляется...");
            ADD(text.substring(3));
        }


        if (text.charAt(0)=='L'&&text.charAt(1)=='I'&&text.charAt(2)=='S'&&text.charAt(3)=='T'){
            System.out.println("Список адресов:");
            LIST();
        }
        }
    }
}
