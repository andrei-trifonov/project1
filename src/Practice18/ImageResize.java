package Practice18;


import java.io.File;

public class ImageResize
{
    public static void main(String[] args)
    {

        String srcFolder = "cats";
        String dstFolder = "resized";


        long start = System.currentTimeMillis();
        int cores = Runtime.getRuntime().availableProcessors();
        try {
            File srcDir = new File(srcFolder);
            File[] files = srcDir.listFiles();

            for (int i = 0; i < cores; i++) {

                File[] partFiles = new File[files.length / cores];
               System.arraycopy(files, ((files.length) / cores) * (i) ,partFiles, 0,(files.length) / cores);
                Thread thread = new Stream(srcFolder, dstFolder, srcDir, start, partFiles, i);
                thread.start();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}