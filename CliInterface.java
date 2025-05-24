package com.namegen.cli;

import com.namegen.model.NameGenerator;

import java.util.List;
import java.util.Scanner;

/**
 * The CliInterface class handles all command-line interactions with the user.
 */
public class CliInterface {
    private final NameGenerator nameGenerator;
    private final Scanner scanner;

    /**
     * Constructor initializes the name generator and scanner for user input.
     */
    public CliInterface() {
        this.nameGenerator = new NameGenerator();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Starts the command-line interface and handles user interaction.
     */
    public void start() {
        System.out.println("Welcome to the Ancient Language Name Generator!");
        
        while (true) {
            displayMainMenu();
            String choice = scanner.nextLine().trim();

            if (choice.equalsIgnoreCase("q")) {
                System.out.println("Thank you for using the Ancient Language Name Generator!");
                break;
            }

            try {
                generateNames();
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    /**
     * Displays the main menu options to the user.
     */
    private void displayMainMenu() {
        System.out.println("\n=== Main Menu ===");
        System.out.println("Press ENTER to generate names");
        System.out.println("Enter 'q' to quit");
    }

    /**
     * Handles the name generation process by gathering user preferences.
     */
    private void generateNames() {
        // Get language preference
        System.out.println("\nAvailable language categories:");
        nameGenerator.getAvailableLanguages().forEach(lang -> System.out.println("- " + lang));
        System.out.print("Enter your chosen language category: ");
        String language = scanner.nextLine().trim();

        // Get gender preference
        System.out.println("\nGender options:");
        System.out.println("1. Male");
        System.out.println("2. Female");
        System.out.println("3. Unisex");
        System.out.print("Enter your choice (1-3): ");
        String gender = scanner.nextLine().trim();

        // Get number of names to generate
        System.out.print("\nHow many names would you like to generate? (1-10): ");
        int count = Integer.parseInt(scanner.nextLine().trim());
        count = Math.min(Math.max(count, 1), 10); // Ensure count is between 1 and 10

        // Generate and display names
        List<String> generatedNames = nameGenerator.generateNames(language, gender, count);
        
        System.out.println("\nGenerated Names:");
        for (int i = 0; i < generatedNames.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, generatedNames.get(i));
        }
    }
} 