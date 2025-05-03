package string.atlassian.leetcode;

import java.util.*;

public class TopKFrequentWords {

    //https://leetcode.com/problems/top-k-frequent-words/
    public static void main(String[] args) {
        TopKFrequentWords atlassian = new TopKFrequentWords();
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        List<String> result1 = topKFrequentApproach1(words, k);
        System.out.println(result1); // Output: ["i", "love"]

        List<String> result2 = topKFrequentApproach2(words, k);
        System.out.println(result2); // Output: ["i", "love"]
    }

    public static List<String> topKFrequentApproach1(String[] words, int k) {

        HashMap<String,Integer> freq=new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        List<String> res = new ArrayList<>(freq.keySet());
        //sorting
        //if two words have the same frequency, then the word with the lower alphabetical order comes first.
        //else most frequent words will come first
        Collections.sort(res, (w1, w2) -> freq.get(w1).equals(freq.get(w2)) ?
                w1.compareTo(w2) : freq.get(w2) - freq.get(w1));

        return res.subList(0, k);
    }

    public static List<String> topKFrequentApproach2(String[] words, int k) {

        List<String> ans = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for(String s : words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        PriorityQueue<Map.Entry<String,Integer>> minHeap = new PriorityQueue<>(new MyComparator());
        for(Map.Entry<String,Integer> e : map.entrySet()){
            minHeap.offer(e);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        while(!minHeap.isEmpty()){
            ans.add(minHeap.poll().getKey());
        }
        Collections.reverse(ans);
        return ans;

    }

    static class MyComparator implements Comparator<Map.Entry<String,Integer>> {
        public int compare(Map.Entry<String,Integer> a,Map.Entry<String,Integer> b) {
            if(a.getValue().equals(b.getValue())){
                return b.getKey().compareTo(a.getKey());
            }
            return a.getValue() - b.getValue();
        }
    }


}
