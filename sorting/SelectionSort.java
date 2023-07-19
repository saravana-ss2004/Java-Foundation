package sorting;

import java.util.Arrays;

/**
 * @Author : Saravanakumar S S 
 * @Email : saravanakumar.ss@zohocorp.com
 * @Since : 17/07/2023
 */

/*
 *  This class implements selection sort
 */
public class SelectionSort {
    /**
     * function to sort an array using selection sort 
     * @param array - takes an array
     */
    public void sorting(int[] array){
        // One by one move boundary of unsorted subarray
        for (int i=0;i<array.length-1;i++){

            // Find the minimum element in unsorted array
            int min = i;
            for(int j=i;j<array.length;j++){
                if(array[min] > array[j]){
                    min = j;
                }
            }

            // Swap the found minimum element with the first
            // element
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
        
    }
    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort();
        
        int[] numbers = {8,2,4,3,1};
        ss.sorting(numbers);

        System.out.println(Arrays.toString(numbers));
    }
}
