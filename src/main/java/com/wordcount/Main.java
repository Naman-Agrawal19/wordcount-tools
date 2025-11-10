package com.wordcount;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            CommandLineInterface.interactiveMode();
        } else {
            CommandLineInterface.commandLineMode(args);
        }
    }
}