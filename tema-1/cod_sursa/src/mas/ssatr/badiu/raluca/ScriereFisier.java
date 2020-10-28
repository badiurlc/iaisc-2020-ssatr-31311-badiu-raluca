package mas.ssatr.badiu.raluca;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ScriereFisier {

    private static final String FILENAME = "output.txt";

    private static BufferedWriter bw = null;
    private static FileWriter fw = null;

    public static void writeToFile(String content) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME,true))) {
            bw.write(content);
            bw.newLine();
          

        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public static void closeFile() {
        try {
            if (bw != null) {
                bw.close();
            }
            if (fw != null) {
                fw.close();
            }
           


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
