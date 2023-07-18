package sorting;

import java.util.Arrays;

/**
 * @Author : Saravanakumar S S
 * @Email : saravanakumar.ss@zohocorp.com
 * @Since : 17/07/2023
 */

 /*
  * This class implements Insertion sort 
  */
public class InsertionSort {

    /**
     * function to sort array using insertion sort
     * @param array - takes an array
     */
    public void sorting(int[] array){
        for(int i=1;i<array.length;i++){
            int current = array[i];
            int previous = i-1;

            /*
             * Move elements of arr[0..i-1], that are
             * greater than key, to one position ahead
             * of their current position  
             */
            while(previous >= 0 && array[previous] > current){
                array[previous+1] = array[previous];
                previous--;
            }
            array[previous+1] = current;
        }
    }
    public static void main(String[] args) {
        InsertionSort ins = new InsertionSort();
        
        int[] numbers = {1, 0, 1, 5, 2, 8, 4};
        ins.sorting(numbers);

        System.out.println(Arrays.toString(numbers));
    }
}
