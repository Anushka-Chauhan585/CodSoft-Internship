import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RuleBasedChatbot {

    private Map<String, String> rules;

    public RuleBasedChatbot() {
        rules = new HashMap<>();
        rules.put("hi", "Hello! How can I help you today?");
        rules.put("hello", "Hi there! What can I do for you?");
        rules.put("how are you", "I'm a bot, but I'm here to help you!");
        rules.put("what is your name", "I'm a rule-based chatbot.");
        rules.put("bye", "Goodbye! Have a nice day!");
        rules.put("default", "I'm sorry, I don't understand that. Can you rephrase?");
    }

    public String getResponse(String userInput) {
        userInput = userInput.toLowerCase();
        for (String key : rules.keySet()) {
            if (userInput.contains(key)) {
                return rules.get(key);
            }
        }
        return rules.get("default");
    }

    public static void main(String[] args) {
        RuleBasedChatbot bot = new RuleBasedChatbot();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Rule-Based Chatbot! Type 'bye' to exit.");

        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("bye")) {
                System.out.println("Bot: " + bot.getResponse("bye"));
                break;
            }
            String response = bot.getResponse(userInput);
            System.out.println("Bot: " + response);
        }

        scanner.close();
    }
}