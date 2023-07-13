import java.util.HashSet;

/**
 * @Author : Saravanakumar S S
 * @Email : saravanakumar.ss@zohocorp.com
 * @Since : 13/07/2023
 */

 /*
  * The class UniqueCollection creates Hashset and implements some methods
  */
public class UniqueCollection {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        //add method adds an element in Hashset
        set.add("One");
        set.add("Two");
        set.add("Three");
        set.add("Four");
        set.add("Four");

        System.out.println(set);

        //remove method removes an element from the hashset
        set.remove("One");

        System.out.println(set);

        //clear method removes all element from the hashset  
        set.clear();

        System.out.println(set);
    }
}