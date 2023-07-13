/**
 * @Author : Saravanakumar S S
 * @Email : saravanakumar.ss@zohocorp.com
 * @Since : 13/07/2023
 */

public class FirstInFirstOut {
    int front, rear, size;
    int capacity;
    int array[];

    public FirstInFirstOut(int capacity){
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        array = new int[this.capacity];
    }


    /** 
     * @param queue - here the queue is reference of the object
     * @return True when Queue is full else False
     */
    boolean isFull(FirstInFirstOut queue){
        return (queue.size == queue.capacity);
    }

      // Queue is empty when size is 0
    /**
     * @param queue - here the queue is reference of an object
     * @return True when Queue is empty else False
     */
    boolean isEmpty(FirstInFirstOut queue){
        return (queue.size == 0);
    }

    /**
     * @param item - takes the value to add in the array
     * Method to add an item to the queue.
     * It changes rear and size*/
    void enqueue(int item){
        if (isFull(this))
            return;
        this.rear = (this.rear + 1) % this.capacity;
        this.array[this.rear] = item;
        this.size = this.size + 1;
    }

    // Method to remove an item from queue.
    // It changes front and size
    int dequeue(){
        if (isEmpty(this))
            return Integer.MIN_VALUE;
 
        int item = this.array[this.front];
        this.front = (this.front + 1)
                     % this.capacity;
        this.size = this.size - 1;
        return item;
    }




    public static void main(String[] args) {

        FirstInFirstOut queue = new FirstInFirstOut(100);
 
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
 
        System.out.println(queue.dequeue());
    }
}
