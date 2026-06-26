package BinarySearch;

import java.util.*;

public class HouseRobberIV {

    static class Solution {

        private boolean isPossible(int[] nums, int mid, int k) {
            int houses = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    houses++;
                    i++; // Skip adjacent house
                }
            }

            return houses >= k;
        }

        public int minCapability(int[] nums, int k) {
            int low = Arrays.stream(nums).min().getAsInt();
            int high = Arrays.stream(nums).max().getAsInt();

            int ans = high;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (isPossible(nums, mid, k)) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {

        // Direct Input
        int[] nums = {2, 3, 5, 9};
        int k = 2;

        Solution obj = new Solution();
        System.out.println(obj.minCapability(nums, k));
    }
}