package HashTable;

import java.util.*;

/*
* 705. Design HashSet
Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:

void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.


Example 1:

Input
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
Output
[null, null, null, true, false, null, true, null, false]

Explanation
MyHashSet myHashSet = new MyHashSet();
myHashSet.add(1);      // set = [1]
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(1); // return True
myHashSet.contains(3); // return False, (not found)
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(2); // return True
myHashSet.remove(2);   // set = [1]
myHashSet.contains(2); // return False, (already removed)


Constraints:

0 <= key <= 10^6
At most 10^4 calls will be made to add, remove, and contains.
*/
public class MyHashSet {
    private int bucketsNumber;
    private LinkedList[] buckets = null;

    public MyHashSet() { this(1021); }

    public MyHashSet(int bucketsNumber) {
        this.bucketsNumber = bucketsNumber;
        this.buckets = new LinkedList[bucketsNumber];
    }

    public void add(int key) {
        int bucketId = getBucketId(key);
        var bucket = this.buckets[bucketId];
        if (bucket == null) {
            bucket = new LinkedList<Integer>();
            this.buckets[bucketId] = bucket;
        }
        if (!bucket.contains((Object) key)) {
            bucket.add(key);
        }
    }

    public boolean contains(int key) {
        int bucketId = getBucketId(key);
        var bucket = this.buckets[bucketId];
        if (bucket == null) {
            return false;
        }
        return bucket.contains(key);
    }

    public void remove(int key) {
        int bucketId = getBucketId(key);
        var bucket = this.buckets[bucketId];
        if (bucket == null) {
            return;
        }
        if (bucket.contains(key)) {
            bucket.remove((Object) key);
        }
    }

    private int getBucketId(int key) {
        return (key & 0x7fffffff) % bucketsNumber;
    }
}
