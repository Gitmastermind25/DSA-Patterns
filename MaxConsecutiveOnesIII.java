import java.util.Scanner;

public class MaxConsecutiveOnesIII {

    static int longestOnes(int[] nums, int k) {
        int low = 0, zeros = 0, res = 0;

        for (int high = 0; high < nums.length; high++) {

            if (nums[high] == 0) {
                zeros++;
            }

            while (zeros > k) {
                if (nums[low] == 0) {
                    zeros--;
                }
                low++;
            }

            res = Math.max(res, high - low + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array in one line
        System.out.println("Enter array elements (space separated 0s and 1s):");
        String[] input = sc.nextLine().split(" ");

        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int ans = longestOnes(nums, k);
        System.out.println("Max consecutive ones = " + ans);

        sc.close();
    }
}
