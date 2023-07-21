package FileHandling;

import java.io.FileOutputStream;
import java.io.FileInputStream;

public class FileOutputInputStream {
    public static void main(String[] args) {
        try {
            FileOutputStream fout = new FileOutputStream("testout.txt");
            String s = "Hello";
            byte[] b = s.getBytes();
            fout.write(b);
            fout.close();
            System.out.println("success...");
        } catch (Exception e) {
            System.out.println(e);
        }

        try{
            FileInputStream fin = new FileInputStream("testout.txt");
            int i=0;    
            while((i=fin.read())!=-1){    
             System.out.print((char)i);    
            }    
            System.out.println();
            fin.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
