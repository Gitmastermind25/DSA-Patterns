import java.util.*;

public class FruitsIntoBasket {

    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < fruits.length; right++) {
            int fruit = fruits[right];
            map.put(fruit, map.getOrDefault(fruit, 0) + 1);

            // Shrink window if more than 2 fruit types
            while (map.size() > 2) {
                int leftFruit = fruits[left];
                map.put(leftFruit, map.get(leftFruit) - 1);
                if (map.get(leftFruit) == 0) map.remove(leftFruit);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of fruits: ");
        int n = sc.nextInt();

        int[] fruits = new int[n];
        System.out.println("Enter the fruits array:");

        // Input array elements
        for (int i = 0; i < n; i++) {
            fruits[i] = sc.nextInt();
        }

        // Output result
        System.out.println("Maximum fruits you can pick: " + totalFruit(fruits));
    }
}
