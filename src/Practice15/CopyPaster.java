package Practice15;




import java.io.*;
import java.util.Objects;
import java.util.Scanner;

// в этом классе мы получаем размер файла
public class CopyPaster {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        new File((System.getProperty("user.dir"))+"\\logger").mkdir();
        File log = new File(System.getProperty("user.dir")+"\\logger\\log.txt");
        if (!log.exists()) {
            try {
                log.createNewFile();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }

        while (true) {

            System.out.println("Введите папку для копирования");
            String apath = in.nextLine();
            File afile = new File(apath);
            System.out.println("Введите путь для копирования");
            String bpath = in.nextLine();
            File bfile = new File(bpath);
            if (afile.exists() && bfile.exists()) {
                new File(bpath+"\\"+ afile.getName()).mkdir();
                bfile = new File(bpath+"\\"+ afile.getName());
                Copy(afile, bfile);
                Print(afile, bfile);
            }
            else
            {
                System.out.println("Ошибка в имени папки");
            }

        }
    }
    private static void Print(File afile, File bfile) throws IOException {
        System.out.println("Содержимое папки " + afile + " скопировано в " + bfile);
        PrintLog("Содержимое папки " + afile + " скопировано в " + bfile);
    }

    private static void Copy (File adirectory, File bdirectory) throws IOException {
        long length = 0;
        try {
            if (adirectory.listFiles() != null) {
                for (File file : adirectory.listFiles()) {
                    File copied = new File(bdirectory.getPath() + "\\" + file.getName());
                    if (file.isFile()) {
                        copied.createNewFile();
                        StringBuffer buffer = new StringBuffer();
                        FileInputStream inputStream = new FileInputStream(file);
                        FileOutputStream outputStream = new FileOutputStream(copied);


                            while (true) {
                                int code = inputStream.read();

                                if (code < 0)
                                    break;

                                char ch = (char) code;
                                outputStream.write(ch);
                            }
                            inputStream.close();
                            outputStream.close();
                    } else
                        copied.mkdir();
                    Copy(file, copied);
                }
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void PrintLog(String input) throws IOException {
        try {
        FileWriter stream = new FileWriter(System.getProperty("user.dir")+"\\logger\\log.txt", true);
        stream.write(input +"\n");
        stream.close();}
        catch (IOException e){
            e.printStackTrace();
        }
    }

}