package com.wordcount;

import java.util.*;
import java.util.regex.Pattern;

public class WordCounter {
    private static final Pattern WORD_PATTERN = Pattern.compile("[^a-zA-Z0-9']+");
    
    public static Map<String, Integer> countWords(String text) {
        Map<String, Integer> wordCount = new HashMap<>();
        
        if (text == null || text.trim().isEmpty()) {
            return wordCount;
        }
        
        String[] words = WORD_PATTERN.split(text.toLowerCase());
        
        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        
        return wordCount;
    }
    
    public static int getTotalWords(Map<String, Integer> wordCount) {
        return wordCount.values().stream().mapToInt(Integer::intValue).sum();
    }
    
    public static int getUniqueWords(Map<String, Integer> wordCount) {
        return wordCount.size();
    }
    
    public static int countCharacters(String text, boolean includeSpaces) {
        if (text == null) return 0;
        if (includeSpaces) {
            return text.length();
        } else {
            return text.replaceAll("\\s+", "").length();
        }
    }
    
    public static List<Map.Entry<String, Integer>> getMostFrequentWords(Map<String, Integer> wordCount, int limit) {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordCount.entrySet());
        entries.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        if (limit > 0 && limit < entries.size()) {
            return entries.subList(0, limit);
        }
        return entries;
    }
}