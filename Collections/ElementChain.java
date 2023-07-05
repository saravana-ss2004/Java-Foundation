/**
 * @author : Saravanakumar S S
 * @Email  : saravanakumar.ss@zohocorp.com
 * @since  : 03/07/2023
 * /




 /*
 * ElementChain class creates head element for linkedlist.
 * The head attribute has default value as null.
 */

public class ElementChain {
    Node head;


    ElementChain(){
        head = null;
    } 


    /*
     * The Node inner class has two attributes int data and Node next.
     * Node class creates node for linkedlist.
     * 
     *     */
    class Node{
        int data;
        Node next;

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
        Node newNode = new Node(val); 


        if(head==null){ 
            head = newNode; 
        }
        else{
            newNode.next = head;
            head = newNode;
        }
    }


    /**
     * The show method used to display the elements
     */
    public void show(){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next; 

        }
        System.out.println();
    }

    /**
     * The method insertAtposition used to insert a data in a specific location
     * @param pos (position) index value for specific location
     * @param val (value) takes the data
     */

    public void insertAtPosition(int pos, int val){
        if(pos == 0){    
            insert(val);  
            return; 
        }
        
        Node newNode = new Node(val);
        Node temp = head;

       
        for(int i=1;i<pos;i++){
            temp = temp.next;
            if(temp == null){
                throw new IndexOutOfBoundsException();
            }
        }

        newNode.next = temp.next;
        temp.next = newNode;

    }

    /**
     * The deleteAt method delete the node of given position
     * @param pos (position) takes the position to remove node
     */
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


    /**
     * The update method updates the data at specific location 
     * @param posn (position) index value for specific location
     * @param val (value)  takes the data
     */
    public void update(int pos, int val){
        Node temp = head;

        for(int i=0;i<pos;i++){
            temp = temp.next;

        }
        temp.data = val;
    }
}