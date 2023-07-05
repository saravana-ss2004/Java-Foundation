/**
 * @author Saravanakumar S S
 * @Email saravanakumar.ss@zohocorp.com
 * @since 03/07/2023
 * /

 
 * /
 * This class used to implements other classes 
 */

public class CollectionBase {
   public static void main(String[] args) {
        implementationOfElementChain();
   }


   /**
    * Implements the methods of LinkedList
    */
   static void implementationOfElementChain(){
      ElementChain list = new ElementChain();

        list.insert(5);
        list.insert(9);
        list.insert(23);

        list.insertAtPosition(2, 34);

        list.update(1,4);

        list.deleteAt(2);

        list.show();
   }
}
