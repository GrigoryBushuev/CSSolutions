package HashTable;
import java.util.LinkedList;

/*
706. Design HashMap

Design a HashMap without using any built-in hash table libraries.

Implement the MyHashMap class:

MyHashMap() initializes the object with an empty map.
void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.


Example 1:

Input
["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
Output
[null, null, null, 1, -1, null, 1, null, -1]

Explanation
MyHashMap myHashMap = new MyHashMap();
myHashMap.put(1, 1); // The map is now [[1,1]]
myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]


Constraints:

0 <= key, value <= 106
At most 104 calls will be made to put, get, and remove.
*/
public class MyHashMap {
    private final int bucketSize = 1021;
    private LinkedList[] buckets;

    private class HashMapItem {
        private int key;
        private int value;
        public HashMapItem(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return this.key;
        }

        public int getValue() {
            return this.value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public int hashCode() {
            return (0x7FFFFFFF) & (31 * this.key);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof HashMapItem)) {
                return false;
            }
            return this.key == ((HashMapItem)obj).key;
        }
    }

    public MyHashMap() {
        this.buckets = new LinkedList[this.bucketSize];
    }

    public void put(int key, int value) {
        int bucketId = getBucketId(key);
        LinkedList bucket = (LinkedList)this.buckets[bucketId];
        HashMapItem item = null;
        if (bucket == null) {
            bucket = new LinkedList();
            item = new HashMapItem(key, value);
            bucket.add(item);
            this.buckets[bucketId] = bucket;
            return;
        }

        int hashMapItemIndex  = indexOf(bucket, key);
        if (hashMapItemIndex == -1) {
            item = new HashMapItem(key, value);
            bucket.add(item);
            return;
        }
        item = (HashMapItem)bucket.get(hashMapItemIndex);
        item.setValue(value);
    }

    public int get(int key) {
        int bucketId = getBucketId(key);
        LinkedList bucket = (LinkedList)this.buckets[bucketId];
        if (bucket == null) {
            return -1;
        }
        int hashMapItemIndex = indexOf(bucket, key);
        if (hashMapItemIndex == -1) {
            return -1;
        }
        var hashMapItem = (HashMapItem)bucket.get(hashMapItemIndex);
        return hashMapItem.getValue();
    }

    public void remove(int key) {
        var bucketId = getBucketId(key);
        var bucket = (LinkedList)this.buckets[bucketId];
        if (bucket == null) {
            return;
        }
        var hashMapItemIndex = indexOf(bucket, key);
        if (hashMapItemIndex == -1) {
            return;
        }
        bucket.remove(hashMapItemIndex);
    }

    private int indexOf(LinkedList bucket, int key) {
        int i = 0;
        for (var item : bucket) {
            if (((HashMapItem)item).getKey() == key) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private int getBucketId(int key) {
        return (0x7fffffff & (31 * key)) % this.bucketSize;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
