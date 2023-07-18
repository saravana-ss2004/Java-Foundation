package Searching;

/**
 * @Author : Saravanakumar S S
 * @Email : saravanakumar.ss@zohocorp.com
 * @Since : 17/07/2023
 */

 /*
  * This class implements Binary search
  */
public class BinarySearch {

    /**
     * function to search an element in the array using Binary search
     * 
     * @param array - takes an array
     * @param target - element to be search
     */
    public int search(int[] array, int target){
        int low = 0;
        int high = array.length-1;

        while(low <= high){
            int middle = low +(high - low) / 2;
            int value = array[middle];

           
            // If target greater, ignore left half
            if(value < target){
                low = middle + 1;
            }

            // If target is smaller, ignore right half
            else if(value > target){
                high = middle -1;
            }

            // Check target is present at middle
            else{
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();

        int[] numbers = {1,3,7,8,9,45};

        System.out.println(bs.search(numbers, 45));
    }
}
