package BinarySearch;

public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int low = 0;
        int high = m;

        while (low <= high) {

            int px = low + (high - low) / 2;
            int py = (m + n + 1) / 2 - px;

            int x1 = (px == 0) ? Integer.MIN_VALUE : nums1[px - 1];
            int x2 = (py == 0) ? Integer.MIN_VALUE : nums2[py - 1];

            int x3 = (px == m) ? Integer.MAX_VALUE : nums1[px];
            int x4 = (py == n) ? Integer.MAX_VALUE : nums2[py];

            if (x1 <= x4 && x2 <= x3) {

                if ((m + n) % 2 == 0) {
                    return (Math.max(x1, x2) + Math.min(x3, x4)) / 2.0;
                }

                return Math.max(x1, x2);

            } else if (x1 > x4) {
                high = px - 1;
            } else {
                low = px + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        // Direct Input
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};

        double median = findMedianSortedArrays(nums1, nums2);

        System.out.println("Median = " + median);
    }
}
