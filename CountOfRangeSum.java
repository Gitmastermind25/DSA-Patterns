public class CountOfRangeSum {

    public static void main(String[] args) {
        int[] nums = {-2, 5, -1};
        int lower = -2;
        int upper = 2;

        int result = countRangeSum(nums, lower, upper);
        System.out.println("Count of Range Sum = " + result);
    }

    public static int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] prefix = new long[n + 1];

        // Build prefix sum
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        return mergeSort(prefix, 0, n, lower, upper);
    }

    private static int mergeSort(long[] arr, int left, int right, int lower, int upper) {
        if (left >= right) return 0;

        int mid = left + (right - left) / 2;
        int count = 0;

        count += mergeSort(arr, left, mid, lower, upper);
        count += mergeSort(arr, mid + 1, right, lower, upper);

        int l = left, r = left;

        // Count valid range sums
        for (int i = mid + 1; i <= right; i++) {
            while (l <= mid && arr[l] < arr[i] - upper) l++;
            while (r <= mid && arr[r] <= arr[i] - lower) r++;
            count += (r - l);
        }

        // Merge step
        long[] temp = new long[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, left, temp.length);

        return count;
    }
}
