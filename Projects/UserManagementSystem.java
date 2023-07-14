package Projects;
/**
 * @Author : Saravanakumar S S
 * @Email : saravanakumar.ss@zohocorp.com
 * @Since : 14/07/2023
 */

 /*
  * User class creates the user and implements signup and login methods
  */
class User {
    private String name;
    private int uid;
    private String password;

    /**
     * @param name - takes the value of user name
     * @param uid - takes the user id from user 
     * @param password - takes the passwors from user 
     * 
     * signUp method creates account using above attributes
     */
    public void signUp(String name, int uid, String password) {
        this.name = name;
        this.uid = uid;
        this.password = password;

        System.out.println("signUp successful");
    }

    
    /**
     * @param uid - takes the user id from user 
     * @param password - takes the passwors from user
     * 
     * login method authenticates a user by checking a provide credentials
     */
    public void login(int uid, String password) {
        if (this.uid == uid && this.password.equals(password)) {
            System.out.println("Login successful! " + name);
        } else {
            System.out.println("Invalid credentials!");
        }
    }
}

public class UserManagementSystem {
    public static void main(String[] args) {
    
        User user1 = new User();

        user1.signUp("john", 1200, "password123");

        user1.login(1200, "password123");
    }
}
