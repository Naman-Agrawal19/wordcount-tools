package com.wordcount;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class WordCounterTest {
    
    @Test
    public void testCountWordsBasic() {
        String text = "hello world hello java";
        Map<String, Integer> result = WordCounter.countWords(text);
        
        assertEquals(3, result.size());
        assertEquals(2, result.get("hello"));
        assertEquals(1, result.get("world"));
        assertEquals(1, result.get("java"));
    }
    
    @Test
    public void testCountWordsEmpty() {
        String text = "";
        Map<String, Integer> result = WordCounter.countWords(text);
        
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void testCountWordsWithPunctuation() {
        String text = "Hello, world! Hello; Java.";
        Map<String, Integer> result = WordCounter.countWords(text);
        
        assertEquals(3, result.size());
        assertEquals(2, result.get("hello"));
        assertEquals(1, result.get("world"));
        assertEquals(1, result.get("java"));
    }
    
    @Test
    public void testGetTotalWords() {
        Map<String, Integer> wordCount = new HashMap<>();
        wordCount.put("hello", 2);
        wordCount.put("world", 1);
        wordCount.put("java", 1);
        
        assertEquals(4, WordCounter.getTotalWords(wordCount));
    }
    
    @Test
    public void testCountCharacters() {
        String text = "hello world";
        assertEquals(11, WordCounter.countCharacters(text, true));
        assertEquals(10, WordCounter.countCharacters(text, false));
    }
}