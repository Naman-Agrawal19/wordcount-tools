A comprehensive text analysis tool that provides detailed word counting statistics and frequency analysis.

## Features
- Total word count
- Unique word count
- Character count (with/without spaces)
- Word frequency analysis
- File processing capabilities
- Command-line and interactive modes

## Installation
### Prerequisites
- Java 8 or higher
- Maven or Ant (optional)

### Build with Maven
```bash
mvn clean compile
mvn package
```

Build with Ant

```bash
ant clean-build
```

Usage

Interactive Mode

```bash
java -jar wordcount-tools.jar
```

Command Line Mode

```bash
# Basic usage
java -jar wordcount-tools.jar input.txt

# Save results to file
java -jar wordcount-tools.jar input.txt --output results.txt
```

Sample Data Files

The project includes several sample files in the data/ directory for testing:

· sample_input.txt - Basic text with repeated words for frequency testing
· test_document.txt - Longer technical document about AI and machine learning
· empty_file.txt - Empty file for edge case testing
· special_characters.txt - Text with various symbols and punctuation

Testing with Sample Files

```bash
# Test with basic sample
java -jar wordcount-tools.jar data/sample_input.txt

# Test with larger document
java -jar wordcount-tools.jar data/test_document.txt --output analysis_results.txt

# Test edge cases
java -jar wordcount-tools.jar data/empty_file.txt
java -jar wordcount-tools.jar data/special_characters.txt
```

Expected Results

· sample_input.txt: ~152 total words, ~97 unique words
· test_document.txt: ~487 total words, ~278 unique words
· empty_file.txt: 0 words (handled gracefully)
· special_characters.txt: Proper handling of punctuation and symbols

Project Structure

```
wordcount-tools/
├── src/                 # Source code
├── test/               # Unit tests
├── data/               # Sample files for testing
│   ├── sample_input.txt
│   ├── test_document.txt
│   ├── empty_file.txt
│   └── special_characters.txt
├── docs/               # Documentation
├── lib/                # Dependencies (if any)
├── pom.xml            # Maven configuration
├── build.xml          # Ant build script
└── README.md          # This file
```# wordcount-tools
