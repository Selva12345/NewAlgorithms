package com.learn;

import java.util.*;

public class TopKFrequentWords {
    public static List<String> getTopKFrequentWords(String paragraph, int k) {
        // Create a map to store word frequencies
        Map<String, Integer> wordFreqMap = new HashMap<>();
        // Split the paragraph into words
        String[] words = paragraph.toLowerCase().split("\\W+");
        String[] words2 = paragraph.toLowerCase().split("[ ,.'?\"]+");
        // Count word frequencies
        for (String word : words) {
            wordFreqMap.put(word, wordFreqMap.getOrDefault(word, 0) + 1);
        }
        // Create a priority queue to store top k frequent words
        PriorityQueue<String> pq = new PriorityQueue<>(
                (a, b) -> wordFreqMap.get(a).equals(wordFreqMap.get(b)) ?
                        b.compareTo(a) : wordFreqMap.get(a) - wordFreqMap.get(b));
        // Iterate over the word frequency map
        for (String word : wordFreqMap.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        // Create a list to store the top k frequent words
        List<String> topKWords = new ArrayList<>();
        // Pop words from the priority queue and add them to the list
        while (!pq.isEmpty()) {
            topKWords.add(0, pq.poll());
        }
        return topKWords;
    }

    public static void main(String[] args) {
        String paragraph = "hello chat gpt , \"How are you ?\" hello,......leetcode chat applications , hello, gpt luck,luck how how..how ";
        int k = 3;
        List<String> topKWords = getTopKFrequentWords(paragraph, k);
        System.out.println("Top " + k + " frequent words: " + topKWords);
    }
}