/**
 * @author Saravanakumar S S
 * @Email saravanakumar.ss@zohocorp.com
 * @since 30/06/20323
 * 
 * 
 * 
 * THis class creates ArrayList and implements some methods 
 * 
 */

import java.util.*;

public class SizeAdaptableSequence {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();


        /**
         * add method used to adds the data in the arraylist
         */
        arr.add(3);
        arr.add(6);
        arr.add(77);
        
        
        /**
         * set method used to update the data
         * first parameter takes position and 
         * second parameter takes tha value to be changed
         */
        arr.set(1,10);

        /**
         * remove method used to delete the data
         */
        arr.remove(0);
        

        for (Object v: arr){
            System.out.println(v);
        }
    }   
}