package Practice15;




import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;


public class SummFinder {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        new File((System.getProperty("user.dir"))+"\\logger").mkdir();
        File log = new File(System.getProperty("user.dir")+"\\logger\\log.txt");
        if (!log.exists()) {
            log.createNewFile();
        }

        while (true) {
            System.out.println("Введите путь до файла/папки");
            String input = in.nextLine();
            File file = new File(input);

            if (file.isDirectory()) {
                if (file.exists()) {
                    Print(getFolderSizeBytes(file), input, true);
                }
                else
                    System.out.println("Папки не существует");
            } else {
                if (file.exists()) {
                    Print(getFileSizeBytes(file), input, false);
                } else
                    System.out.println("Файла не существует!");
            }
        }
    }
    private static void Print(float size, String input, boolean folder) throws IOException {
        if (size > 1024*1024*1024){
            if (folder == true) {
                System.out.println("Размер папки " + input + " составляет " + size / (1024 * 1024 * 1024) + "Gb");
                PrintLog("Размер папки " + input + " составляет " + size / (1024 * 1024 * 1024) + "Gb");
            }
            else {
                System.out.println("Размер файла " + input + " составляет " + size / (1024 * 1024 * 1024) + "Gb");
                PrintLog("Размер файла " + input + " составляет " + size / (1024 * 1024 * 1024) + "Gb");
            }
            return;
        }
        if (size > 1024*1024){
            if (folder == true){
                System.out.println("Размер папки " + input+ " составляет " + size/(1024*1024) + "Mb");
                PrintLog("Размер папки " + input+ " составляет " + size/(1024*1024) + "Mb");
            }
            else {
                System.out.println("Размер файла " + input + " составляет " + size / (1024 * 1024) + "Mb");
                PrintLog("Размер файла " + input + " составляет " + size / (1024 * 1024) + "Mb");
            }
            return;
        }
        if (size > 1024){
            if (folder == true){
                System.out.println("Размер папки " + input + " составляет "+ size/(1024) + "Kb");
                PrintLog("Размер папки " + input + " составляет "+ size/(1024) + "Kb");
            }
            else
                System.out.println("Размер файла " + input + " составляет "+ size/(1024) + "Kb");
            PrintLog("Размер файла " + input + " составляет "+ size/(1024) + "Kb");
            return;
        }
        else {
            if (folder == true) {
                System.out.println("Размер папки " + input + " составляет " + size + "b");
                PrintLog("Размер папки " + input + " составляет " + size + "b");
            }
            else
            {
                System.out.println("Размер файла " + input + " составляет " + size + "b");
                PrintLog("Размер файла " + input + " составляет " + size + "b");
            }
            return;
        }
    }
    private static float getFileSizeBytes(File file) {
        return  file.length();
    }
    private static float getFolderSizeBytes(File directory) {
        long length = 0;
        if (directory.listFiles()!= null) {
            for (File file : directory.listFiles()) {

                if (file.isFile())
                    length += file.length();
                else
                    length += getFolderSizeBytes(file);
            }
        }
        return length;
    }
    private static void PrintLog(String input) throws IOException {
        FileWriter stream = new FileWriter(System.getProperty("user.dir")+"\\logger\\log.txt", true);
        stream.write(input +"\n");
        stream.close();
    }

}