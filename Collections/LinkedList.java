public class LinkedList {
    Node head;

    class Node{
        int data;
        Node next;

        Node(int val){
            data = val;
            next = null;
        }
    }

    LinkedList(){
        head = null;
    } 

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


    public void show(){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;

        }
        System.out.println();
    }

    public void insertAtPos(int pos, int val){
        if(pos == 0){
            insert(val);
            return;
        }
        
        Node newNode = new Node(val);

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