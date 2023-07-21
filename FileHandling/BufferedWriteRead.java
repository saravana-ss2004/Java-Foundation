package FileHandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferedWriteRead {
    public static void main(String[] args) {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("bufferWrite.txt"));
            bw.write("Hello!!");
            bw.flush();
            bw.close();

        } catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }

        try{
            BufferedReader br = new BufferedReader(new FileReader("bufferWrite.txt"));
            String s;
            while((s=br.readLine()) != null){
                System.out.println(s);
            }
            br.close();
        }
        catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
