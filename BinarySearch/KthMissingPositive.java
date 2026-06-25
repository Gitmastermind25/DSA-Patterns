package BinarySearch;

public class KthMissingPositive {

    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int l = 0;
        int r = arr.length - 1;
        int mid = -1;

        while (l <= r) {
            mid = l + (r - l) / 2;
            int missing_number = arr[mid] - (mid + 1);

            if (missing_number < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l + k;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;

        KthMissingPositive obj = new KthMissingPositive();
        System.out.println(obj.findKthPositive(arr, k));
    }
}