public class MaxAbsoluteSubarraySum {
    public static void main(String[] args) {

        // input array
        int[] nums = {1, -3, 2, 3, -4};

        int maxEnding = 0, minEnding = 0;
        int maxSum = 0, minSum = 0;

        for (int n : nums) {
            maxEnding = Math.max(n, maxEnding + n);
            minEnding = Math.min(n, minEnding + n);

            maxSum = Math.max(maxSum, maxEnding);
            minSum = Math.min(minSum, minEnding);
        }

        int result = Math.max(Math.abs(maxSum), Math.abs(minSum));
        System.out.println(result);
    }
}
