package Projects;

/**
 * @Author : Saravanakumar S S
 * @Email : saravanakumar.ss@zohocorp.com
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
     * 
     * @param key takes key
     * @return hash value
     */
    public int getHashValue(K key) {
        return key.hashCode() % 20;
    }

    /**
     * This method store an entry into the array
     * 
     * @param key   takes key
     * @param value takes value
     * 
     */
    public void put(K key, V value) {
        int bucketValue = getHashValue(key);

        Entry<K, V> entry = new Entry<K, V>(key, value);

        if (head == null) {
            buckets[bucketValue] = entry;
            this.head = entry;
        } else {

            // when collison was happenedx
            if (buckets[bucketValue] != null) {
                if (key != buckets[bucketValue].key) {
                    entry.next = head;
                    head.prev = entry;
                    buckets[bucketValue] = entry;
                    head = entry;

                } else {
                    buckets[bucketValue].value = value;
                    head = buckets[bucketValue];

                }
            } else {
                entry.next = head;
                head.prev = entry;
                buckets[bucketValue] = entry;
                head = entry;

            }
        }
    }

    /**
     * This method used to get the value from LinkedHashmap
     * 
     * @param key takes key
     * @return respective value of the key
     */
    public V get(K key) {
        int bucketValue = getHashValue(key);

        Entry<K, V> entry = buckets[bucketValue];

        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }


    /**
     * This method prints all the values from tha LinkedHashmap
     */
    public void values() {
        Entry<K, V> temp = head;

        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CustomLinkedHashMap<Integer, String> ll = new CustomLinkedHashMap<>();
        ll.put(33, "Mosh");
        ll.put(53, "Hamedani");
        ll.put(93, "Bro code");
        ll.put(93, "code with harry");
        ll.put(113, "some");
        ll.put(52, "thing");

        ll.values();
        System.out.println(ll.get(93));

    }
}