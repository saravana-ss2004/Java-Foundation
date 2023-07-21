package FileHandling;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferedOutputInputStream {
    public static void main(String[] args) {
        try{
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("bufferedStream.txt"));
            String s= "Hello";
            byte[] b= s.getBytes();
            bos.write(b);
            bos.flush();
            bos.close();
        }
        catch(Exception e){
            System.out.println(e);
        }

        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("bufferedStream.txt"));
            int i=0;    
            while((i=bis.read())!=-1){    
             System.out.print((char)i);    
            }    
            System.out.println();
            bis.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
