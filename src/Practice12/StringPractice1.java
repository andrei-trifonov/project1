package Practice12;

public class StringPractice1 {
    static int sum = 0, cht = 0;
    static String tmp = "";
    static String text = "Вася заработал 5100 рублей, Петя - 7563 рубля, а Маша - 30100 рублей";

    public static void main(String[] args) {


        for (int i = 0; i < text.length(); i++) {
            int askii = (int) text.charAt(i);
            if (askii > 47 && askii < 58) {
                tmp += text.charAt(i);

                if (i+1 < text.length()){
                if ((int) text.charAt(i + 1) < 47 || (int) text.charAt(i + 1) > 58) {
                    if (cht==0 || cht ==2) {
                        sum += Integer.parseInt(tmp);
                    }
                    cht++;
                    tmp = "";
                }
                }
            }

        }
        System.out.println(sum);
    }

}
