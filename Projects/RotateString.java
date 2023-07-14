package Projects;

import java.util.Scanner;

public class RotateString {
    void rotate(String str, int n) {
        
        for (int i = 0; i < n; i++) {
            str = str.substring(1, str.length()) + str.charAt(0);
        }
        System.out.println(str);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter str");
        String str = sc.nextLine();

        System.out.println("enter n");
        int n = sc.nextInt();
        
        RotateString rs = new RotateString();
        rs.rotate(str, n);
    }
}
