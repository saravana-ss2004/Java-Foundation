package Projects;

import java.util.ArrayList;

/**
 * @Author : Saravanakumar S S
 * @Email :  saravanakumar.ss@zohocorp.com
 * @Since : 19/07/2023
 */




/**
 * This class create LinkedHashmap and implements its methods
 */
public class CustomLinkedHashMap<K, V> {
    Entry head;
    Entry tail;

    ArrayList<Integer> al = new ArrayList<>();
    
    


    class Entry{
        Entry prev;
        K key;
        V value;
        Entry next;


        public Entry(K key, V value){
            this.key = key;
            this.value = value;
            this.prev=null;
            this.next=null;
        }
    }
    
    
    public CustomLinkedHashMap(){
        head = null;
        tail = null;
    }

    public int bucket(K key){
        int hascode = key.hashCode();
        System.out.println(hascode);
        return hascode;

    }


    public void put(K key, V value){
        bucket(key);
    }


    public static void main(String[] args) {
        CustomLinkedHashMap<Integer, String>  ll = new CustomLinkedHashMap<>();

    }
}
