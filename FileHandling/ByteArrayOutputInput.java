package FileHandling;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

public class ByteArrayOutputInput {
    public static void main(String[] args) {
        try {
            FileOutputStream fis1 = new FileOutputStream("byteArray.txt");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            String s = "Hello!!!";
            byte[] b = s.getBytes();

            baos.write(b);
            baos.writeTo(fis1);

            baos.flush();
            baos.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            byte[] buf = { 35, 36, 37, 38 };
            
            ByteArrayInputStream byt = new ByteArrayInputStream(buf);
            int k = 0;
            while ((k = byt.read()) != -1) {
                char ch = (char) k;
                System.out.println(ch);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
