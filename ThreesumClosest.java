import java.util.*;

public class ThreesumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];

        for(int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }

                if (sum < target) {
                    left++;        // increase sum
                } else if (sum > target) {
                    right--;       // decrease sum
                } else {
                    return sum;    // perfect match
                }
            }
        }

        return closest;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 2, 1, -4 };
        int target = 1;

        ThreesumClosest obj = new ThreesumClosest();
        int result = obj.threeSumClosest(nums, target);

        System.out.println("Closest sum = " + result);
    }
}
