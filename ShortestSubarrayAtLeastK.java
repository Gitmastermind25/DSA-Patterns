import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarrayAtLeastK {

    public static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;

        // Prefix sum array
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        Deque<Integer> dq = new ArrayDeque<>();
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {

            // Check if current prefix can form a valid subarray
            while (!dq.isEmpty() && prefix[i] - prefix[dq.peekFirst()] >= k) {
                ans = Math.min(ans, i - dq.pollFirst());
            }

            // Maintain increasing order of prefix sums
            while (!dq.isEmpty() && prefix[i] <= prefix[dq.peekLast()]) {
                dq.pollLast();
            }

            dq.addLast(i);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {

        // ---- INPUT ----
        int[] nums = {2, -1, 2};
        int k = 3;

        // ---- OUTPUT ----
        int result = shortestSubarray(nums, k);
        System.out.println("Shortest subarray length: " + result);
    }
}
