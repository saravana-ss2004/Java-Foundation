package sorting;

import java.util.Arrays;

/**
 * @Author : Saravanakumar S S
 * @Email : saravanakumar.ss@zohocorp.com
 * @Since : 17/07/2023
 */

 /*
  * This class implements bubble sort
  */
public class BubbleSort {

    /**
     * function to sort an array using bubble sort
     * @param array - takes an array
     */
    public void sorting(int[] array){

        /*
         * One by one move boundary of unsorted subarray
         */
        for(int i=0;i<array.length;i++){

            for(int j=1;j<array.length;j++){

                if(array[j] < array[j-1]){

                    // Swap arr[j] and arr[j+1]
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();

        int[] numbers = {1,2,3,4};
        bs.sorting(numbers);

        System.out.println(Arrays.toString(numbers));
    }
}
