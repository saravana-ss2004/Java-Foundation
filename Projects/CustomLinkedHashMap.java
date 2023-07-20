package Projects;

/**
 * @Author : Saravanakumar S S
 * @Email :  saravanakumar.ss@zohocorp.com
 * @Since : 19/07/2023
 */

/*
 * This class create LinkedHashmap and implements its methods
 */
public class CustomLinkedHashMap<K, V> {
    Entry<K, V>[] buckets;
    Entry<K, V> head;

    /**
     * This class creates entry(node) for LinkedHasmap
     */
    class Entry<K, V> {
        Entry<K, V> prev;
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    public CustomLinkedHashMap() {
        this.head = null;
        this.buckets = new Entry[20];
    }

    /**
     * This method generates hash value to store an entry
     * @param key takes key
     * @return hash value
     */
    public int getHashValue(K key) {
        return key.hashCode() % 20;
    }

    /**
     * This method store an entry into the array
     * @param key takes key
     * @param value takes value
     * 
     */
    public void put(K key, V value) {
        int bucketValue = getHashValue(key);

        Entry<K, V> entry = new Entry<K, V>(key, value);

        if (head == null) {
            buckets[bucketValue] = entry;
            this.head = entry;
        } 
        else {

            // when collison is happened
            if (buckets[bucketValue] != null) {
                if (key != buckets[bucketValue].key) {
                    entry.prev = buckets[bucketValue];
                    entry.next = buckets[bucketValue].next;
                    buckets[bucketValue] = entry;
                } 
                else {
                    buckets[bucketValue].value = value;
                }
            } else {
                entry.prev = head;
                head.next = entry;
                buckets[bucketValue] = entry;
                head = entry;

            }
        }
    }

    /**
     * This method used to get the value from LinkedHashmap
     * @param key takes key
     * @return respective value of the key
     */
    public V get(K key){
        int bucketValue = getHashValue(key);

        Entry<K,V> entry = buckets[bucketValue];

        while(entry != null){
            if(entry.key.equals(key)){
                return entry.value;
            }
            entry = entry.prev;
        }
        return null;
    }

    public static void main(String[] args) {
        CustomLinkedHashMap<Integer, String> ll = new CustomLinkedHashMap<>();
        ll.put(33, "saravanakumar");
        ll.put(53, "vijaykumar");
        ll.put(73,"sivakumar");
        ll.put(93,"Ram kumar");
        ll.put(113,"karthikkumar");
        ll.put(56,"something");

       System.out.println(ll.get(56));

    }
}
