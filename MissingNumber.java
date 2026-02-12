import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements (distinct numbers from 0 to " + n + "):");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Call the solution method
        int missing = findMissingNumber(nums);
        System.out.println("The missing number is: " + missing);

        sc.close();
    }

    // XOR method
    public static int findMissingNumber(int[] nums) {
        int xor = nums.length;
        for (int i = 0; i < nums.length; i++) {
            xor ^= i ^ nums[i];
        }
        return xor;
    }
}
