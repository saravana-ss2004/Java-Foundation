import java.util.TreeMap;

/**
 * @author : Saravanakumar S S
 * @Email : saravanakumar.ss@zohocorp.com
 * @Since : 13/07/2023
 */


 /*
  *OrderdMap class creates TreeMap and implements some methods
  * TreeMap is just an ordered Map 
  */

public class OrderedMap {
    public static void main(String[] args){
        TreeMap<Integer, String> fruits = new TreeMap<>();
        
        /**
         * put method adds an element into map
         * it contains two arguments one is key and another is value
         */
        fruits.put(1, "Mango");
        fruits.put(2, "Apple");
        fruits.put(4, "Orange");
        fruits.put(3, "Grapes");

       /**
        * map don't contain duplicate value
        * rather it overrides the existing one 
        */
        fruits.put(2, "Banana");

        /*
         * remove method removes an element from TreeMap
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
