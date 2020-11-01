package Practice14;
import java.util.*;

public class NumGen {
   static ArrayList<String> numlist1 = new ArrayList();
   static HashSet<String> numlist2 = new HashSet();
   static TreeSet<String> numlist3 = new TreeSet();
   static long Start;
   static long Finish;
   static String randomNum(){
        String number = "";
        final char[] alphabet = {'А', 'В', 'Е', 'К', 'М','Н','О','Р', 'С','Т', 'У', 'Х'};

        Random random = new Random();
        int index = random.nextInt(alphabet.length);
        number+=alphabet[index];
        number+= String.valueOf(100+random.nextInt(899));
        while(true){
            index = random.nextInt(alphabet.length);
            if (number.charAt(0)!=alphabet[index]) {
                number += alphabet[index];
                while (true) {
                    index = random.nextInt(alphabet.length);
                    if (number.charAt(0) != alphabet[index] && number.charAt(4) != alphabet[index]) {
                        number += alphabet[index];
                        break;
                    }
                }
                break;
            }
        }
        index = 1+random.nextInt(199);
        if (index>9){
            number+=String.valueOf(index);
        }
        else {
            number+="0";
            number+=String.valueOf(index);
        }

        return number;

   }
    static void binarySort(String text){
    Collections.sort(numlist1);
    Start = System.nanoTime();
    if (Collections.binarySearch(numlist1, text)>0){
        Finish = System.nanoTime();
        System.out.println("Бинарный поиск: номер найден, поиск занял: " + (Finish-Start) + "нс");}
    else {
        Finish = System.nanoTime();
        System.out.println("Бинарный поиск: номер не найден, поиск занял: " + (Finish - Start) + "нс");
    }

    }
    static void simpleSort(String text){
       Start = System.nanoTime();
        for (int i = 0; i < numlist1.size(); i++) {
            if (numlist1.get(i).equals(text)){
                Finish = System.nanoTime();
                System.out.println("Поиск перебором: номер найден, поиск занял: " + (Finish-Start) + "нс");
                return;
            }
        }
        Finish = System.nanoTime();
        System.out.println("Поиск перебором: номер не найден, поиск занял: " + (Finish-Start) + "нс");
    }
    static void hashSetSort(String text){
       Start = System.nanoTime();
       if (numlist2.contains(text)){
           Finish = System.nanoTime();
           System.out.println("Поиск hashSet: номер найден, поиск занял: "  + (Finish-Start) + "нс");
       }
       else
       {
           Finish = System.nanoTime();
           System.out.println("Поиск hashSet: номер не найден, поиск занял: "  + (Finish-Start) + "нс");
   }}
   static void treeSetSort(String text){
       Start = System.nanoTime();
       if (numlist3.contains(text)){
           Finish = System.nanoTime();
           System.out.println("Поиск treeSet: номер найден, поиск занял: " + (Finish-Start) + "нс");
       }
       else
       {
           Finish = System.nanoTime();
           System.out.println("Поиск treeSet: номер не найден, поиск занял: " + (Finish-Start) + "нс");
}}

    public static void main(String[] args) {
        for (int i = 0; i < 2000001; i++) {

            String tmp = randomNum();
            numlist1.add(tmp);
            numlist2.add(tmp);
            numlist3.add(tmp);
            if (i<10)
            System.out.println(tmp);
        }
        while (true){

            Scanner in = new Scanner(System.in);
            String search = in.nextLine();
            simpleSort(search);
            binarySort(search);
            hashSetSort(search);
            treeSetSort(search);
        }
    }
}
