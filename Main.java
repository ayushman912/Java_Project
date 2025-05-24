package com.namegen;

import com.namegen.cli.CliInterface;

/**
 * Main class that serves as the entry point for the Ancient Language Name Generator application.
 */
public class Main {
    /**
     * Main method that starts the application.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        CliInterface cli = new CliInterface();
        cli.start();
    }
} 