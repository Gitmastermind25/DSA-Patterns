package BinarySearch;

import java.util.Arrays;

public class Problem34 {

    public int FindLeftmost(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int leftmost = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                leftmost = mid;
                r = mid - 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return leftmost;
    }

    public int FindRightmost(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int rightmost = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                rightmost = mid;
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return rightmost;
    }

    public int[] SearchRange(int[] nums, int target) {
        int leftmost = FindLeftmost(nums, target);
        int rightmost = FindRightmost(nums, target);
        return new int[]{leftmost, rightmost};
    }

    public static void main(String[] args) {
        Problem34 obj = new Problem34();

        //int[] nums = {1,2,3,4,5,5,5,6,7,8,9,10};
        int[] nums = {0,2,2,2,2,2};
        int target = 2;

        int[] result = obj.SearchRange(nums, target);

        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Target: " + target);
        System.out.println("Result: " + Arrays.toString(result));
    }
}