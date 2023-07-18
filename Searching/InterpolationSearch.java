package Searching;

/**
 * @Author : Saravanakumar S S
 * @Email : saravanakumar.ss@zohocorp.com
 * @Since : 17/07/2023
 */

 /*
  * This class implements interpolation search
  */
public class InterpolationSearch {

    /**
     * function to search an element in the array using interpolation search
     * 
     * @param array - takes an array
     * @param target - element to be search
     */
    public int search(int[] array, int target){
        int high = array.length-1;
        int low = 0;

        while(target <= array[high] && target >= array[low] && low<=high){
            int probe = low +  (high - low) * (target - array[low]) / (array[high] - array[low]);
            System.out.println(array[probe]);

             // Condition of target found
            if(array[probe] == target){
                return probe;
            }

            // If target is larger, target is in right sub array
            else if(array[probe] < target){
                low = probe +1;
            }

            // If target is smaller, target is in left sub array
            else{
                high = probe-1;
            }
            
        }
        return -1;
    }
    public static void main(String[] args) {
        InterpolationSearch ips = new InterpolationSearch();
        
        int[] numbers = {1,2,4,8,16,32,64,128,256};
        System.out.println(ips.search(numbers, 64));
    }
}
