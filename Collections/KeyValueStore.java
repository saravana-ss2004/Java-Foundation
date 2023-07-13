/**
 * @author : Saravanakumar S S
 * @Email  : saravanakumar.ss@zohocorp.com
 * @Since  : 13/07/2023
 */


/**
 * KeyValueStore class creates HashMap and implements some methods
 */

import java.util.HashMap;

public class KeyValueStore {
    public static void main(String[] args){
        HashMap<Integer, String> fruits = new HashMap<>();

        /**
         * put method adds an element into map
         * it contains two arguments one is key and another is value
         */
        fruits.put(1, "Mango");
        fruits.put(2, "Apple");
        fruits.put(3, "Orange");
        fruits.put(4, "Grapes");


       /**
        * map don't contain duplicate value
        * rather it overrides the existing one 
        */
        fruits.put(2, "Banana");

        /*
         * remove method removes an element from HashMap
         */
        fruits.remove(2);


      /*
       * get method gets an element specified in the argument
       */
      System.out.println(fruits.get(1));

      System.out.println(fruits.keySet());

      System.out.println(fruits.values());

      System.out.println(fruits);

    }
}
