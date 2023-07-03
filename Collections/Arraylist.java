import java.util.*;

public class Arraylist {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(3);
        arr.add(6);
        arr.add(77);
        
        
        Collections.sort(arr);

        arr.set(1,10);
        arr.remove(0);


        Iterator i = arr.iterator();

        while(i.hasNext()){
            System.out.println(i.next());
        }

        

        for (Object v: arr){
            System.out.println(v);
        }
    }   
}