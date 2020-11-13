package Practice15;




import java.io.*;
import java.util.Scanner;


public class Logger {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        new File((System.getProperty("user.dir"))+"\\logger").mkdir();
        File file = new File(System.getProperty("user.dir")+"\\logger\\log.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        while (true) {
            String input = in.nextLine();

            PrintLog(input);
        }


    }
    private static void PrintLog(String input) throws IOException {
       FileWriter stream = new FileWriter(System.getProperty("user.dir")+"\\logger\\log.txt", true);
        stream.write(input +"\n");
        System.out.println("log item added");
        stream.close();
    }


}