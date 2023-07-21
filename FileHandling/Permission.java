package FileHandling;

import java.io.FilePermission;

public class Permission {
    public static void main(String[] args) {
        try{
            FilePermission fp1 = new FilePermission("bufferedStream.txt", "read, write, execute");
            System.out.println(fp1.getActions());
        }
        catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
