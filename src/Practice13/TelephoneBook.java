package Practice13;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelephoneBook {
    static Map<String, String> phonebook = new HashMap();
    static boolean Check(String text){
        boolean found = false;
        String textNum;
        textNum = normalizeNumber(text);
        if (textNum!=null){
            for (Map.Entry<String, String> entry : phonebook.entrySet()) {
                if (textNum.equals(entry.getValue())) {
                    System.out.println(entry.getKey()+"="+entry.getValue());
                    found = true;
                }
            }
        }
        if (found == false) {
            for (Map.Entry<String, String> entry : phonebook.entrySet()) {
                if (text.equals(entry.getKey())) {
                    System.out.println(entry.getKey() + "=" +entry.getValue());
                    found = true;
                }
            }
        }
        return found;
    }
    static  String normalizeNumber(String number){
        Pattern check = Pattern.compile("[А-ЯA-Zа-яa-z]");
        Matcher matcherCheck = check.matcher(number);
        if (matcherCheck.find()) {
            return null;
        }
        String pattern = "";
        String tmp="";

        for(int i=0;i<number.length();i++){
            if ((int)number.charAt(i)>47 && (int)number.charAt(i)<58){
                tmp += number.charAt(i);
            }
        }

        if (tmp.length()<11){
            if (tmp.length()<=10&&(tmp.charAt(0)=='7' || tmp.charAt(0)=='8')){
                return(null);
            }
            if (tmp.length()<10){
                return(null);
            }
        }
        if (tmp.length()>11){
            return(null);
        }
        if (tmp.charAt(0)=='8'){
            tmp=tmp.substring(1,tmp.length());
            tmp="+7 ("+tmp;
        }
        else {
            if (tmp.charAt(0)=='7'){
                tmp="+7 ("+tmp.substring(1,tmp.length());
            }
            else {
                tmp="+7 ("+tmp;
            }
        }
        tmp=tmp.substring(0,7)+") "+tmp.substring(7,10)+"-"+tmp.substring(10,12)+"-"+tmp.substring(12,14);
        return (tmp);
    }
    static void ADD(String name, String number){
        String tmp = normalizeNumber(number);
        if (tmp != null) {
            phonebook.put(name, tmp);
        }
    }
    static  void LIST(){

        for (Map.Entry entry: phonebook.entrySet()) {

            System.out.println(entry);

        }

    }


    public static void main(String[] args) {
        while (true) {
            boolean isContact;
            Scanner in = new Scanner(System.in);
            String line = in.nextLine();
            if (line!= null&& line.charAt(0)=='L'&&line.charAt(1)=='I'&&line.charAt(2)=='S'&&line.charAt(3)=='T') {
                LIST();
            } else if(line!=null){
                isContact = Check(line);
                if (isContact == false) {
                    Pattern check = Pattern.compile("[0-9]");
                    Matcher matcherCheck = check.matcher(line);
                    if (matcherCheck.find()) {
                        System.out.println("Имя контакта:");
                        String line2 = in.nextLine();
                        isContact = Check(line2);
                        if (isContact == false){
                        ADD(line2, line);}
                    } else {
                        check = Pattern.compile("[A-ЯA-Z][а-яa-z]{1,}");
                        matcherCheck = check.matcher(line);
                        if (matcherCheck.find()) {
                            System.out.println("Введите номер:");
                            String line2 = in.nextLine();
                            isContact = Check(line2);
                            if (isContact == false){
                            ADD(line, line2);}
                        }
                    }
                }
            }
        }
    }
}
