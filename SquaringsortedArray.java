import java.util.*;

public class SquaringsortedArray {

    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;

        // Step 1: find last negative index
        int neg = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                neg = i;
            } else {
                break;
            }
        }

        int pos = neg + 1;       // first non-negative
        int[] result = new int[n];
        int index = 0;

        // Step 2: merge
        while (neg >= 0 && pos < n) {
            int negSquare = nums[neg] * nums[neg];
            int posSquare = nums[pos] * nums[pos];

            if (negSquare < posSquare) {
                result[index++] = negSquare;
                neg--;
            } else {
                result[index++] = posSquare;
                pos++;
            }
        }

        // Step 3: remaining negatives
        while (neg >= 0) {
            result[index++] = nums[neg] * nums[neg];
            neg--;
        }

        // Step 4: remaining positives
        while (pos < n) {
            result[index++] = nums[pos] * nums[pos];
            pos++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {-7, -3, -1, 2, 4, 6};
        int[] nums2 = {-4, -1, 0, 3, 10};

        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + Arrays.toString(sortedSquares(nums1)));

        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.toString(sortedSquares(nums2)));
    }
}
