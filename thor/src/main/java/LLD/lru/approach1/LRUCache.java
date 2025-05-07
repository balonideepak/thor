package LLD.lru.approach1;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V>  {
    private final int capacity;
    private final Node<K, V> head=new Node(0,0) , tail =new Node(0,0);
    private final Map<K, Node<K, V>> cache =new HashMap<>();


    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public V get(int key){
        if(cache.containsKey(key)){
            Node<K, V> node = cache.get(key);

            remove(node);
            insert(node);

            return node.value;
        }
        else{
            return null;
        }
    }




    public void put(K key , V value){
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }

        if(cache.size() == capacity){
            remove(tail.prev);
        }

        insert(new Node<>(key , value));

    }

    private void remove(Node node) {
        cache.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    private void insert(Node node) {
        cache.put((K) node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

}
