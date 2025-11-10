package com.wordcount;

import java.util.*;
import java.io.*;

public class CommandLineInterface {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void interactiveMode() {
        System.out.println("=== Wordcount Tools ===");
        System.out.println("1. Enter text manually");
        System.out.println("2. Process text file");
        System.out.println("3. Exit");
        
        while (true) {
            System.out.print("\nChoose option (1-3): ");
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    processManualText();
                    break;
                case "2":
                    processFile();
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    public static void commandLineMode(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java -jar wordcount.jar <filename> [--output result.txt]");
            return;
        }
        
        String inputFile = args[0];
        String outputFile = null;
        
        for (int i = 1; i < args.length; i++) {
            if (args[i].equals("--output") && i + 1 < args.length) {
                outputFile = args[i + 1];
            }
        }
        
        try {
            processFile(inputFile, outputFile);
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
    
    private static void processManualText() {
        System.out.println("\nEnter your text (press Enter twice to finish):");
        StringBuilder text = new StringBuilder();
        String line;
        
        while (!(line = scanner.nextLine()).isEmpty()) {
            text.append(line).append("\n");
        }
        
        if (text.length() == 0) {
            System.out.println("No text entered.");
            return;
        }
        
        displayResults(text.toString());
    }
    
    private static void processFile() {
        System.out.print("Enter file path: ");
        String filePath = scanner.nextLine();
        
        try {
            processFile(filePath, null);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void processFile(String filePath, String outputFile) throws IOException {
        if (!FileProcessor.fileExists(filePath)) {
            throw new IOException("File not found: " + filePath);
        }
        
        String text = FileProcessor.readFile(filePath);
        String results = generateReport(text, filePath);
        
        System.out.println(results);
        
        if (outputFile != null) {
            FileProcessor.writeResultsToFile(outputFile, results);
            System.out.println("Results saved to: " + outputFile);
        }
    }
    
    private static void displayResults(String text) {
        System.out.println(generateReport(text, "Manual Input"));
    }
    
    private static String generateReport(String text, String source) {
        Map<String, Integer> wordCount = WordCounter.countWords(text);
        int totalWords = WordCounter.getTotalWords(wordCount);
        int uniqueWords = WordCounter.getUniqueWords(wordCount);
        int charsWithSpaces = WordCounter.countCharacters(text, true);
        int charsWithoutSpaces = WordCounter.countCharacters(text, false);
        
        StringBuilder report = new StringBuilder();
        report.append("\n=== WORD COUNT ANALYSIS ===\n");
        report.append("Source: ").append(source).append("\n");
        report.append("Total words: ").append(totalWords).append("\n");
        report.append("Unique words: ").append(uniqueWords).append("\n");
        report.append("Characters (with spaces): ").append(charsWithSpaces).append("\n");
        report.append("Characters (without spaces): ").append(charsWithoutSpaces).append("\n");
        
        if (totalWords > 0) {
            report.append("\n--- MOST FREQUENT WORDS ---\n");
            List<Map.Entry<String, Integer>> frequentWords = 
                WordCounter.getMostFrequentWords(wordCount, 10);
            
            for (int i = 0; i < Math.min(frequentWords.size(), 10); i++) {
                Map.Entry<String, Integer> entry = frequentWords.get(i);
                report.append(String.format("%2d. %-15s : %d\n", 
                    i + 1, entry.getKey(), entry.getValue()));
            }
        }
        
        return report.toString();
    }
}