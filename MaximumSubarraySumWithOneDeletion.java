public class MaximumSubarraySumWithOneDeletion {

    public static int maximumSum(int[] arr) {
        int n = arr.length;

        int noDel = arr[0];      // max sum ending here with no deletion
        int oneDel = 0;          // max sum ending here with one deletion
        int ans = arr[0];

        for (int i = 1; i < n; i++) {
            oneDel = Math.max(oneDel + arr[i], noDel);
            noDel = Math.max(arr[i], noDel + arr[i]);
            ans = Math.max(ans, Math.max(noDel, oneDel));
        }

        return ans;
    }

    // Example run
    public static void main(String[] args) {
        int[] arr = {1, -2, 0, 3};
        System.out.println(maximumSum(arr)); // Output: 4
    }
}
