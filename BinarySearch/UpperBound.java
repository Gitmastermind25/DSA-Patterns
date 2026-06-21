package BinarySearch;

public class UpperBound {
    public int upperbound(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        int ans = nums.length;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] > target) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    static void main(String[] args) {
        UpperBound lb = new UpperBound();
        int[] nums = {1, 3, 5, 5, 5, 6, 8};
        int target = 5;
        int ans = lb.upperbound(nums, target);
        System.out.println(ans);
    }

}
