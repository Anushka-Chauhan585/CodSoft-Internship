import java.util.Scanner;

public class BookRecommendationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define book recommendations
        String[][] fictionBooks = {
            {"The Hobbit by J.R.R. Tolkien", "Harry Potter and the Sorcerer's Stone by J.K. Rowling"},
            {"1984 by George Orwell", "The Catcher in the Rye by J.D. Salinger"},
            {"Ulysses by James Joyce", "Infinite Jest by David Foster Wallace"}
        };
        
        String[][] nonFictionBooks = {
            {"Sapiens by Yuval Noah Harari", "Educated by Tara Westover"},
            {"Thinking, Fast and Slow by Daniel Kahneman", "Guns, Germs, and Steel by Jared Diamond"},
            {"The Power Broker by Robert A. Caro", "Gödel, Escher, Bach by Douglas Hofstadter"}
        };

        // Get user input for type of book
        System.out.println("Enter the type of book (Fiction/Non-Fiction): ");
        String bookType = scanner.nextLine().trim().toLowerCase();

        // Get user input for level of book
        System.out.println("Enter the level of book (Beginner/Intermediate/Advanced): ");
        String bookLevel = scanner.nextLine().trim().toLowerCase();

        // Initialize the recommendations array
        String[] recommendations = null;

        // Determine the level index
        int levelIndex = -1;
        switch (bookLevel) {
            case "beginner":
                levelIndex = 0;
                break;
            case "intermediate":
                levelIndex = 1;
                break;
            case "advanced":
                levelIndex = 2;
                break;
            default:
                System.out.println("Invalid level entered. Please enter Beginner, Intermediate, or Advanced.");
                System.exit(0);
        }

        // Provide recommendations based on type and level
        if (bookType.equals("fiction")) {
            recommendations = fictionBooks[levelIndex];
        } else if (bookType.equals("non-fiction")) {
            recommendations = nonFictionBooks[levelIndex];
        } else {
            System.out.println("Invalid type entered. Please enter Fiction or Non-Fiction.");
            System.exit(0);
        }

        // Print the recommendations
        System.out.println("Recommended books for you:");
        for (String book : recommendations) {
            System.out.println(book);
        }

        scanner.close();
    }
}
