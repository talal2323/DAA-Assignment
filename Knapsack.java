import java.util.*;

public class Knapsack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of items:");
        int n = scanner.nextInt();

        System.out.println("Enter maximum weight capacity:");
        int W = scanner.nextInt();

        int[] weights = new int[n];
        int[] benefits = new int[n];

        System.out.println("Enter weight and benefit of each item:");
        for (int i = 0; i < n; i++) {
            System.out.print("Weight of item " + (i + 1) + ": ");
            weights[i] = scanner.nextInt();
            System.out.print("Benefit of item " + (i + 1) + ": ");
            benefits[i] = scanner.nextInt();
        }

        // Dynamic programming table
        int[][] dp = new int[n + 1][W + 1];

        // Building dynamic programming table
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(benefits[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Displaying dynamic programming table
        System.out.println("\nDynamic Programming Table:");
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                System.out.printf("%-5d", dp[i][w]);
            }
            System.out.println();
        }

        // maximum value items
        List<Integer> selectedItems = new ArrayList<>();
        int i = n, w = W;
        while (i > 0 && w > 0) {
            if (dp[i][w] != dp[i - 1][w]) {
                selectedItems.add(i);
                w -= weights[i - 1];
            }
            i--;
        }

        // Displaying the items selected for maximum value
        System.out.println("\nItems selected for maximum value:");
        for (int item : selectedItems) {
            System.out.println("Item " + item + " (weight: " + weights[item - 1] + ", benefit: " + benefits[item - 1] + ")");
        }
    }
}
