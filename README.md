# Ancient Language Name Generator

A Java application that generates names inspired by various ancient and mythological languages including Latin, Greek, Norse, Egyptian, and Sanskrit.

## Features

- Generate names inspired by different ancient languages:
  - Latin
  - Greek
  - Norse
  - Egyptian
  - Sanskrit
- Choose between male, female, or unisex names
- Generate multiple names at once (up to 10)
- Command-line interface for easy interaction

## Requirements

- Java 11 or higher
- Maven

## Building the Project

To build the project, run the following command in the project root directory:

```bash
mvn clean package
```

This will create a runnable JAR file in the `target` directory.

## Running the Application

After building the project, you can run it using:

```bash
java -jar target/ancient-language-name-gen-1.0-SNAPSHOT.jar
```

## How to Use

1. When the application starts, you'll be presented with a main menu.
2. Press ENTER to start generating names or 'q' to quit.
3. Choose a language category from the available options.
4. Select a gender preference (Male, Female, or Unisex).
5. Enter the number of names you want to generate (1-10).
6. The application will display your generated names.

## Project Structure

- `src/main/java/com/namegen/`
  - `Main.java` - Application entry point
  - `model/NameGenerator.java` - Core name generation logic
  - `cli/CliInterface.java` - Command-line interface handling

## Contributing

Feel free to submit issues and enhancement requests! 