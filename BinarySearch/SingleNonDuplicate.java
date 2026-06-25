package BinarySearch;

public class SingleNonDuplicate {

    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0;
        int h = n - 1;
        int mid;

        while (l < h) {
            mid = l + (h - l) / 2;
            boolean isEven = (h - mid) % 2 == 0;

            if (nums[mid] == nums[mid + 1]) {
                if (isEven) {
                    l = mid + 2;
                } else {
                    h = mid - 1;
                }
            } else if (nums[mid] == nums[mid - 1]) {
                if (isEven) {
                    h = mid - 2;
                } else {
                    l = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }

        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};

        SingleNonDuplicate obj = new SingleNonDuplicate();
        System.out.println(obj.singleNonDuplicate(nums));
    }
}