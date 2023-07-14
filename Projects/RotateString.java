package Projects;

import java.util.Scanner;

/**
 * @Author : Saravanakumar S S
 * @Email : saravanakumar.ss@zohocorp.com
 * @Since : 14/07/2023
 */


 /*
  * RotateString class takes input form user and rotate the string "n" number of times
  */
public class RotateString {

    /**
     * rotate method rotates the string "n" number of times.
     * 
     * @param word - takes the input value from user
     * @param n - takes the value of number of rotations
    */
    void rotate(String word, int n) {
        for (int i = 0; i < n; i++) {
            word = word.substring(1, word.length()) + word.charAt(0);
        }
        System.out.println(word);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string to rotate: ");
        String word = sc.nextLine();

        System.out.println("How many times to rotate: ");
        int numberOfRotation = sc.nextInt();
        
        RotateString rs = new RotateString();
        rs.rotate(word, numberOfRotation);
    }
}
