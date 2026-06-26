package BinarySearch;

import java.util.Arrays;

public class SplitArrayLargestSum {

    public int countPartitions(int[] a, int maxSum) {
        int partitions = 1;
        long subarraySum = 0;

        for (int num : a) {
            if (subarraySum + num <= maxSum) {
                subarraySum += num;
            } else {
                partitions++;
                subarraySum = num;
            }
        }

        return partitions;
    }

    public int splitArray(int[] nums, int k) {
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int partitions = countPartitions(nums, mid);

            if (partitions > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        SplitArrayLargestSum solution = new SplitArrayLargestSum();

        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;

        int result = solution.splitArray(nums, k);

        System.out.println("Minimum Largest Sum: " + result);
    }
}