public class CoinChange {

    public static void coinChange(int amount) {
        int[] denominations = {1000, 500, 100, 50, 20, 10, 5, 2, 1};  // Denominations of Pakistani currency
        int[] counts = new int[denominations.length];  // Array to store counts of each denomination

        // Loop through each denomination
        for (int i = 0; i < denominations.length; i++) {
            // Calculate the number of coins of denomination needed
            counts[i] = amount / denominations[i];

            amount %= denominations[i];
        }

        // Displaying denominations of currency required
        System.out.println("Denominations for Rs. " + amount + ":");
        for (int i = 0; i < denominations.length; i++) {
            if (counts[i] > 0) {
                System.out.println(counts[i] + " x Rs. " + denominations[i]);
            }
        }
    }

    public static void main(String[] args) {
        int amount = 1988;
        coinChange(amount);
    }
}
