package BinarySearch;


public class CountOccurrences {

    public int firstOccurrence(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        int first = -1;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (nums[mid] == target) {
                first = mid;
                h = mid - 1;
            } else if (nums[mid] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return first;
    }

    public int lastOccurrence(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        int last = -1;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (nums[mid] == target) {
                last = mid;
                l = mid + 1;
            } else if (nums[mid] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return last;
    }

    public int countOccurrences(int[] nums, int target) {
        int first = firstOccurrence(nums, target);

        if (first == -1) {
            return 0;
        }

        int last = lastOccurrence(nums, target);

        return last - first + 1;
    }

    public static void main(String[] args) {
        CountOccurrences obj = new CountOccurrences();

        int[] nums = {1, 2, 2, 2, 3, 4};
        int target = 2;

        System.out.println(obj.countOccurrences(nums, target));
    }
}
