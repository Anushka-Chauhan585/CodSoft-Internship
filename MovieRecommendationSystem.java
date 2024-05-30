import java.util.Scanner;

public class MovieRecommendationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define movie recommendations
        String[][] fictionMovies = {
            {"The Hobbit - Easy", "Harry Potter - Easy"},
            {"Inception - Intermediate", "The Matrix - Intermediate"},
            {"Interstellar - Hard", "2001: A Space Odyssey - Hard"}
        };
        
        String[][] nonFictionMovies = {
            {"The Social Dilemma - Easy", "13th - Easy"},
            {"Inside Job - Intermediate", "Free Solo - Intermediate"},
            {"Won't You Be My Neighbor? - Hard", "The Act of Killing - Hard"}
        };

        String[][] romComMovies = {
            {"Crazy Rich Asians - Easy", "10 Things I Hate About You - Easy"},
            {"Silver Linings Playbook - Intermediate", "The Big Sick - Intermediate"},
            {"Eternal Sunshine of the Spotless Mind - Hard", "Punch-Drunk Love - Hard"}
        };

        String[][] romanceMovies = {
            {"The Notebook - Easy", "Pride and Prejudice - Easy"},
            {"La La Land - Intermediate", "Atonement - Intermediate"},
            {"Blue Is the Warmest Color - Hard", "Brokeback Mountain - Hard"}
        };

        String[][] comedyMovies = {
            {"Superbad - Easy", "Anchorman - Easy"},
            {"The Grand Budapest Hotel - Intermediate", "Tropic Thunder - Intermediate"},
            {"Dr. Strangelove - Hard", "Being John Malkovich - Hard"}
        };

        String[][] thrillerMovies = {
            {"A Quiet Place - Easy", "Gone Girl - Easy"},
            {"Se7en - Intermediate", "Zodiac - Intermediate"},
            {"Oldboy - Hard", "Memento - Hard"}
        };

        String[][] crimeMovies = {
            {"Ocean's Eleven - Easy", "Catch Me If You Can - Easy"},
            {"The Departed - Intermediate", "Heat - Intermediate"},
            {"The Godfather - Hard", "Goodfellas - Hard"}
        };

        String[][] actionMovies = {
            {"Mad Max: Fury Road - Easy", "Die Hard - Easy"},
            {"The Dark Knight - Intermediate", "Gladiator - Intermediate"},
            {"John Wick - Hard", "The Raid - Hard"}
        };

        String[][] dramaMovies = {
            {"Forrest Gump - Easy", "The Pursuit of Happyness - Easy"},
            {"Fight Club - Intermediate", "Whiplash - Intermediate"},
            {"There Will Be Blood - Hard", "Schindler's List - Hard"}
        };

        String[][] horrorMovies = {
            {"The Conjuring - Easy", "Insidious - Easy"},
            {"Hereditary - Intermediate", "The Witch - Intermediate"},
            {"The Exorcist - Hard", "Suspiria - Hard"}
        };

        // Get user input for type of movie
        System.out.println("Enter the type of movie (Fiction/Non-Fiction/Rom-Com/Romance/Comedy/Thriller/Crime/Action/Drama/Horror): ");
        String movieType = scanner.nextLine().trim().toLowerCase();

        // Get user input for level of movie
        System.out.println("Enter the level of movie (Easy/Intermediate/Hard): ");
        String movieLevel = scanner.nextLine().trim().toLowerCase();

        // Initialize the recommendations array
        String[] recommendations = null;

        // Determine the level index
        int levelIndex = -1;
        switch (movieLevel) {
            case "easy":
                levelIndex = 0;
                break;
            case "intermediate":
                levelIndex = 1;
                break;
            case "hard":
                levelIndex = 2;
                break;
            default:
                System.out.println("Invalid level entered. Please enter Easy, Intermediate, or Hard.");
                System.exit(0);
        }

        // Provide recommendations based on type and level
        switch (movieType) {
            case "fiction":
                recommendations = fictionMovies[levelIndex];
                break;
            case "non-fiction":
                recommendations = nonFictionMovies[levelIndex];
                break;
            case "rom-com":
                recommendations = romComMovies[levelIndex];
                break;
            case "romance":
                recommendations = romanceMovies[levelIndex];
                break;
            case "comedy":
                recommendations = comedyMovies[levelIndex];
                break;
            case "thriller":
                recommendations = thrillerMovies[levelIndex];
                break;
            case "crime":
                recommendations = crimeMovies[levelIndex];
                break;
            case "action":
                recommendations = actionMovies[levelIndex];
                break;
            case "drama":
                recommendations = dramaMovies[levelIndex];
                break;
            case "horror":
                recommendations = horrorMovies[levelIndex];
                break;
            default:
                System.out.println("Invalid type entered. Please enter a valid movie type.");
                System.exit(0);
        }

        // Print the recommendations
        System.out.println("Recommended movies for you:");
        for (String movie : recommendations) {
            System.out.println(movie);
        }

        scanner.close();
    }
}
