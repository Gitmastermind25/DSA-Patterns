import java.util.*;
class SmallestSubarraySum {

    public static void main(String[] args) {

        // Hardcoded input
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};

        int ans = minSubArrayLen(target, nums);
        System.out.println(ans);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            // Shrink window when sum is enough
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
