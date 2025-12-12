public class MinimumSizeSubarray {
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0; // Start of the sliding window
        int sum = 0;  // Current sum of the window
        int minLen = Integer.MAX_VALUE; // To track minimum length

        // Expand the window with right pointer
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right]; // Add current element to sum

            // Shrink the window from the left while sum >= target
            while (sum >= target) {
                int windowLen = right - left + 1;
                if (windowLen < minLen) {
                    minLen = windowLen; // Update minimum length
                }
                sum -= nums[left]; // Remove left element from sum
                left++;            // Move left pointer
            }
        }

        // If no valid subarray was found, return 0
        if (minLen == Integer.MAX_VALUE) {
            return 0;
        } else {
            return minLen;
        }
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};

        int result = minSubArrayLen(target, nums);
        System.out.println("Minimum size subarray length: " + result);
    }
}

