package BinarySearch;

public class LowerBound {
    public int lowerBound(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        int ans = nums.length;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    static void main(String[] args) {
        LowerBound lb = new LowerBound();
        int[] nums = {1, 3, 5,6};
        int target = 6;
        int ans = lb.lowerBound(nums, target);
        System.out.println(ans);
    }

}
