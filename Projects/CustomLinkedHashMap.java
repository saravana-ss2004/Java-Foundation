package Projects;


/**
 * @Author : Saravanakumar S S
 * @Email :  saravanakumar.ss@zohocorp.com
 * @Since : 19/07/2023
 */

 /*
  * This class creates entry(node) for LinkedHashmap
  */
class Entry<K,V>{
    K key;
    V value;
    Entry<K, V> next;
    Entry<K, V> prev;

    public Entry(K key, V value){
        this.key = key;
        this.value = value;
    }

}

/**
 * This class create LinkedHashmap and implements its methods
 */
public class CustomLinkedHashMap<K, V> {
    
    public CustomLinkedHashMap(){
        
    }
}
