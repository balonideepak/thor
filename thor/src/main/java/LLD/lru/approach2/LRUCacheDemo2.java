package LLD.lru.approach2;

public class LRUCacheDemo2 {

    //https://medium.com/justeattakeaway-tech/building-an-lru-cache-in-java-a-simple-approach-using-linkedhashmap-7e984b223cdf

    public static void main(String[] args) {
        LRUCache<Integer, Integer> cache = new LRUCache<>(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache); //output {1=1, 2=2}
        cache.get(1);    // returns 1
        System.out.println(cache); //output {2=2, 1=1}
        cache.put(3, 3); // Remove 2 and add 3
        System.out.println(cache); //output {1=1, 3=3}
        cache.get(2);    // return null
        cache.put(4, 4); // Remove 1 and add o 4
        System.out.println(cache); //output {3=3, 4=4}
        cache.get(3);    // return 3
        System.out.println(cache); //output {4=4, 3=3}
        cache.get(4);    // return 4
        System.out.println(cache); //output {3=3, 4=4}
    }
}
