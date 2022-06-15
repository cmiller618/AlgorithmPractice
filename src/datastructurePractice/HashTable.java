package datastructurePractice;

import java.util.ArrayList;
import java.util.Objects;

public class HashTable <K, V>{
    K key;
    V value;
    final int hashCode;

    HashTable<K, V> next;

    public HashTable(K key, V value, int hashCode){
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
    }
}

//This example came from geeksforgeeks. Learning how a hash table is created.
class Map<K, V>{
    private ArrayList<HashTable<K, V>> hashArray;
    private int capacity;
    private int size;

    public Map(){
        hashArray = new ArrayList<>();
        capacity = 10;
        size = 0;

        for(int i = 0; i < capacity; i++){
            hashArray.add(null);
        }
    }

    public int size() {return size;}
    public boolean isEmpty() {return size() == 0;}

    private final int hashCode(K key){
        return Objects.hashCode(key);
    }

    private int getHashIndex(K key){
        int hashcode = this.hashCode(key);
        int index = hashcode % capacity;
        if(index < 0){
            index = index * -1;
        }
        return index;

    }

    public V remove(K key){
        int hashIndex = getHashIndex(key);
        int hashCode = hashCode(key);

        HashTable<K, V> head = hashArray.get(hashIndex);

        HashTable<K, V> previous = null;

        while(head != null){
            if(head.key.equals(key) && hashCode == head.hashCode)
                break;
            previous = head;
            head = head.next;
        }

        if(head == null){
            return null;
        }

        size--;

        if(previous != null){
            previous.next = head.next;
        }else{
            hashArray.set(hashIndex, head.next);
        }

        return head.value;
     }


     public V get(K key){
        int hashIndex = getHashIndex(key);
        int hashCode = hashCode(key);

        HashTable<K, V> head = hashArray.get(hashIndex);

        //cycles through hash table to find key
        while(head != null){
            if(head.key.equals(key) && head.hashCode == hashCode){
                return head.value;
            }
            head = head.next;

        }

        return null;
     }

     public void add(K key, V value){
        int hashIndex = getHashIndex(key);
        int hashCode = hashCode(key);
        HashTable<K, V> head = hashArray.get(hashIndex);

        while(head != null){
            if(head.key.equals(key) && head.hashCode == hashCode){
                head.value = value;
                return;
            }
            head = head.next;
        }

        size++;
        head = hashArray.get(hashIndex);
        HashTable<K, V> newNode = new HashTable<K, V>(key, value, hashCode);
        newNode.next = head;
        hashArray.set(hashIndex, newNode);
        if((1.0 * size) / capacity >= 0.7) {
            ArrayList<HashTable<K, V>> temp = hashArray;
            hashArray = new ArrayList<>();
            capacity = 2 * capacity;
            size = 0;
            for(int i = 0; i < capacity; i++){
                hashArray.add(null);
            }

            for(HashTable<K, V> headNode : temp){
                while(headNode != null){
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }

     }

}