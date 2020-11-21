package Practice14;
import java.util.*;

public class NumGen {

   static long Start;
   static long Finish;
   static void randomNum(String str){ 
       String[] patternWords = {"A", "B", "E", "K", "M", "H", "O", "P", "C", "T", "Y", "X"};
       String[] patternNumbers = {"000", "111", "222", "333", "444", "555", "666", "777", "888", "999"};
       ArrayList<String> carNumbers = new ArrayList<>();
           for(int i=0; i<12; i++){
               for(int j=0; j<10; j++){
                   for(int k=0; k<12; k++){
                       for(int l=0; l<12; l++){
                           for (int m=1; m<200; m++){
                               carNumbers.add(patternWords[i] + patternNumbers[j] + patternWords[k] + patternWords[l] + m);

                           }
                       }
                   }
               }
           }
           ArrayList<String> numlist1 = new ArrayList(carNumbers);
           HashSet<String> numlist2 = new HashSet(carNumbers);
           TreeSet<String> numlist3 = new TreeSet(carNumbers);
           binarySort(str, numlist1);
           simpleSort(str, numlist1);
           hashSetSort(str, numlist2);
           treeSetSort(str, numlist3);
   }
    static void binarySort(String text, ArrayList<String> numlist1){
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
    static void simpleSort(String text, ArrayList<String> numlist1){
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
    static void hashSetSort(String text, HashSet<String> numlist2){
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
   static void treeSetSort(String text,TreeSet<String> numlist3 ){
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
         
       
        while (true){
            Scanner in = new Scanner(System.in);
            String search = in.nextLine();
            randomNum(search);
        }
    }
}
