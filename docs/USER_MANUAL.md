User Manual - Wordcount Tools

Introduction

Wordcount Tools is a Java application for analyzing text documents and generating word count statistics.

Getting Started

Installation

1. Ensure Java 8+ is installed
2. Download the JAR file or build from source
3. Run the application

Basic Usage

Interactive Mode

1. Run without arguments: java -jar wordcount-tools.jar
2. Choose option 1 for manual text input
3. Type your text and press Enter twice to finish
4. View the analysis results

File Processing

1. Run with file argument: java -jar wordcount-tools.jar document.txt
2. Or use interactive mode and choose option 2
3. Enter the file path when prompted

Output Options

· Results are displayed in console by default
· Use --output filename.txt to save results to file

Features Explained

Word Count

· Total Words: Count of all words in the text
· Unique Words: Count of distinct words
· Character Count: Total characters with and without spaces

Frequency Analysis

· Shows top 10 most frequent words
· Displays word and occurrence count
· Helps identify key terms in the text

Supported File Formats

· Plain text files (.txt)
· Basic file encoding support

Troubleshooting

· File not found: Check file path and permissions
· Empty results: Verify file contains text
· Encoding issues: Ensure file uses supported encoding
