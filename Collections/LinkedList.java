/**
 * LinkedList class creates head element for linkedlist.
 * The head attribute has default value as null.
 * 
 * @author : Saravanakumar S S
 * @Email  : saravanakumar.ss@zohocorp.com
 * @since  : 03/07/2023
 */

public class LinkedList {
    Node head;


    LinkedList(){
        head = null;
    } 


    /*
     * The Node inner class has two attributes int data and Node next.
     * Node class creates node for linkedlist.
     */
    class Node{
        int data; // The data attribute contains the actual data.
        Node next; // The next attribute contains the next object reference.


        /**
         * Constructor for Node class
         * @param val (value) parameter takes the data to store in Node.
         */
        Node(int val){
            data = val;
            next = null;
        }
    }

    
    /**
     * insert method set the data to the head element.
     * @param val (value) takes the data.
     */
    public void insert(int val){
        Node newNode = new Node(val); //Creates Node element with some data.

        /**
         * if   : assigns newNode to head
         * else : head element is assigned to new node's next object reference and new node assigned to head element
         */

        if(head==null){ 
            head = newNode; 
        }
        else{
            newNode.next = head;
            head = newNode;
        }
    }


    /**
     * The show used to display the elements
     */
    public void show(){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next; // jump to next element(object)

        }
        System.out.println();
    }

    /**
     * The method insertAtposition used to insert an data in a specific location
     * @param pos (position) index value for specific location
     * @param val (value) takes the data
     */

    public void insertAtPosition(int pos, int val){
        if(pos == 0){   // location 0 is similar to insert method. 
            insert(val);  // So calling insert method
            return;  // stop the function
        }
        
        Node newNode = new Node(val); // creating new node element

        Node temp = head;
        
        for(int i=1;i<pos;i++){
            temp = temp.next;
            if(temp == null){
                throw new IndexOutOfBoundsException("Invalid position "+ pos);
            }
        }

        newNode.next = temp.next;
        temp.next = newNode;

    }


    public void deleteAt(int pos){
        if(head == null){
            throw new IndexOutOfBoundsException();
        }

        if(pos == 0){
            head = head.next;
            return;
        }

        Node temp = head;
        Node prev = null;

        for(int i=1;i<=pos;i++){
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;

    }

    public void update(int pos, int val){
        Node temp = head;
        for(int i=0;i<pos;i++){
            temp = temp.next;

        }
        temp.data = val;
    }
}