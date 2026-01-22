public class maxSubarraySumCircular {

    public static int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxSum = nums[0], currMax = 0;
        int minSum = nums[0], currMin = 0;

        for (int n : nums) {
            currMax = Math.max(n, currMax + n);
            maxSum = Math.max(maxSum, currMax);

            currMin = Math.min(n, currMin + n);
            minSum = Math.min(minSum, currMin);

            totalSum += n;
        }

        // If all elements are negative
        if (maxSum < 0) return maxSum;

        return Math.max(maxSum, totalSum - minSum);
    }

    public static void main(String[] args) {
        // Input
        int[] nums = {5, -3, 5};

        // Output
        int result = maxSubarraySumCircular(nums);
        System.out.println(result);
    }
}
