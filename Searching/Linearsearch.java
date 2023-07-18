package Searching;

/**
 * @Author : Saravanakumar S S
 * @Email : saravanakumar.ss@zohocorp.com
 * @Since : 17/07/2023
 */

 /*
  * This class implements Linear serach
  */
public class Linearsearch {
   
    /**
     * function to search an element in the array using linear search
     * 
     * @param array - takes an array
     * @param target - element to be search
     */
    public int search(int[] array, int target){
        for(int i=0;i<array.length;i++){
            if(target == array[i]){
                return i;
            }
        }
        return -1;
    }

     public static void main(String[] args) {
        Linearsearch ls =new Linearsearch();

        int[] numbers = {1,6,9,5,3,7,8};

        System.out.println(ls.search(numbers, 8));
    }
}
