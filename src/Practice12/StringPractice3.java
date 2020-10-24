package Practice12;
import java.util.Scanner;

public class StringPractice3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String pattern = "";
        String tmp="";
        String number = in.nextLine();
        for(int i=0;i<number.length();i++){
           if ((int)number.charAt(i)>47 && (int)number.charAt(i)<58){
               tmp += number.charAt(i);
           }
        }
        System.out.println();
        if (tmp.length()<11){
            if (tmp.length()<=10&&(tmp.charAt(0)=='7' || tmp.charAt(0)=='8')){
            System.out.println("Неверный формат номера");
            System.exit(0);
            }
            if (tmp.length()<10){
                System.out.println("Неверный формат номера");
                System.exit(0);
            }
        }
        if (tmp.length()>11){
            System.out.println("Неверный формат номера");
            System.exit(0);
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
        System.out.println(tmp);
    }



}
