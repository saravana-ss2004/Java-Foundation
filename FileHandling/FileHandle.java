package FileHandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
// import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileHandle {
    public static void main(String[] args) {
        try{

            BufferedWriter bf =new BufferedWriter(new FileWriter("output.txt"));
            BufferedReader br = new BufferedReader(new FileReader("test.txt"));
            
            String s;


            while( (s=br.readLine()) != null ){
                bf.write(s+"\n");
            }
            br.close();
            bf.close();
        }
        catch(Exception e){
            return;
        }
    }
}
