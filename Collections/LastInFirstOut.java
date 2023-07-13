import java.util.Stack;

/**
 * @Author : Saravanakumar S S
 * @Email : saravanakumar S S
 * @Since : 13/07/2023
 */

 /*
  * LastInFirstOut class creates stack and implements some methods
  */

public class LastInFirstOut {
    public static void main(String[] args) {
        Stack<String> books = new Stack<>();

        /*
         * push method adds an element on top of the stack
         */
        books.push("A man called Ove");
        books.push("The lord of the rings");
        books.push("The great gatsby");
        books.push("Sapiens");

        System.out.println(books);

        /**
         * peek methods returns the last element of the stack
         */
        System.out.println(books.peek()); 

        /*
         *size method return the size of the stack 
         */
        System.out.println(books.size());

        /*
         *pop method deletes the last element and return that
         */
        System.out.println(books.pop());

        System.out.println(books.size());
    }
}