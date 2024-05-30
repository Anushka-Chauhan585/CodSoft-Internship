import java.util.Scanner;

public class ProductRecommendationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define product recommendations
        String[][] electronicsProducts = {
            {"USB Cable - $10", "Mouse - $15"},
            {"Bluetooth Speaker - $50", "Wireless Earbuds - $70"},
            {"Smartphone - $500", "Laptop - $1000"}
        };

        String[][] clothingProducts = {
            {"T-shirt - $10", "Socks - $5"},
            {"Jeans - $40", "Sweater - $50"},
            {"Leather Jacket - $200", "Designer Dress - $500"}
        };

        String[][] groceryProducts = {
            {"Bread - $2", "Milk - $3"},
            {"Chicken - $10", "Cheese - $8"},
            {"Olive Oil - $25", "Organic Honey - $30"}
        };

        // Get user input for type of product
        System.out.println("Enter the type of product (Electronics/Clothing/Grocery): ");
        String productType = scanner.nextLine().trim().toLowerCase();

        // Get user input for amount range
        System.out.println("Enter the amount range (Low/Medium/High): ");
        String amountRange = scanner.nextLine().trim().toLowerCase();

        // Initialize the recommendations array
        String[] recommendations = null;

        // Determine the range index
        int rangeIndex = -1;
        switch (amountRange) {
            case "low":
                rangeIndex = 0;
                break;
            case "medium":
                rangeIndex = 1;
                break;
            case "high":
                rangeIndex = 2;
                break;
            default:
                System.out.println("Invalid range entered. Please enter Low, Medium, or High.");
                System.exit(0);
        }

        // Provide recommendations based on type and amount range
        switch (productType) {
            case "electronics":
                recommendations = electronicsProducts[rangeIndex];
                break;
            case "clothing":
                recommendations = clothingProducts[rangeIndex];
                break;
            case "grocery":
                recommendations = groceryProducts[rangeIndex];
                break;
            default:
                System.out.println("Invalid type entered. Please enter Electronics, Clothing, or Grocery.");
                System.exit(0);
        }

        // Print the recommendations
        System.out.println("Recommended products for you:");
        for (String product : recommendations) {
            System.out.println(product);
        }

        scanner.close();
    }
}
