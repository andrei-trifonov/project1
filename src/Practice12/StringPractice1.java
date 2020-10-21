package Practice12;

public class StringPractice1 {
    static int sum = 0;
    static String tmp = "";
    static String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

    public static void main(String[] args) {


        for (int i = 0; i < text.length(); i++) {
            int askii = (int) text.charAt(i);
            if (askii > 47 && askii < 58) {
                tmp += text.charAt(i);

                if (i+1 < text.length()){
                if ((int) text.charAt(i + 1) < 47 || (int) text.charAt(i + 1) > 58) {
                    sum += Integer.parseInt(tmp);
                    tmp = "";
                }
                }
            }

        }
        System.out.println(sum);
    }

}
