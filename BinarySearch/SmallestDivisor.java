package BinarySearch;

import java.util.Arrays;

public class SmallestDivisor {

    public int getSum(int[] nums, int divisor) {
        int sum = 0;

        for (int x : nums) {
            sum += x / divisor;

            if (x % divisor != 0) {
                sum++;
            }
        }

        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {

        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int actualSum = getSum(nums, mid);

            if (actualSum <= threshold) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        SmallestDivisor obj = new SmallestDivisor();

        int[] nums = {1, 2, 5, 9};
        int threshold = 6;

        System.out.println(obj.smallestDivisor(nums, threshold));
    }
}