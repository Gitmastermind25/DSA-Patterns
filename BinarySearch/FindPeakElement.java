package BinarySearch;

public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return r;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};

        FindPeakElement obj = new FindPeakElement();
        System.out.println(obj.findPeakElement(nums));
    }
}
