import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;

        Arrays.sort(nums); // O(n log n)
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate fixed values
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int target = -nums[i];
            int l = i + 1;
            int r = n - 1;

            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    // Move l and r past duplicates
                    int leftVal = nums[l];
                    while (l < r && nums[l] == leftVal) l++;

                    int rightVal = nums[r];
                    while (l < r && nums[r] == rightVal) r--;
                } else if (sum < target) {
                    l++; // need larger sum
                } else {
                    r--; // need smaller sum
                }
            }
        }
        return res;
    }

    // Simple test
    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ans = threeSum(a);
        System.out.println(ans); // expected [[-1, -1, 2], [-1, 0, 1]]
    }
}
