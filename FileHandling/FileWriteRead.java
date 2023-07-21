package FileHandling;

import java.io.FileReader;
import java.io.FileWriter;


public class FileWriteRead {
    public static void main(String[] args) {
        try {
            FileWriter w = new FileWriter("output.txt");
            String content = "Hello!!!!";
            w.write(content);
            w.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }

        try {
            FileReader reader = new FileReader("output.txt");
            int s;
            while ((s=reader.read()) != -1) {
                System.out.print((char)s);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
