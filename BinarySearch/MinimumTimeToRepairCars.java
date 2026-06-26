package BinarySearch;

import java.util.*;

public class MinimumTimeToRepairCars {

    static class Solution {

        private boolean isPossible(int[] ranks, long mid, int cars) {
            long carsRepaired = 0;

            for (int rank : ranks) {
                carsRepaired += (long) Math.sqrt((double) mid / rank);
            }

            return carsRepaired >= cars;
        }

        public long repairCars(int[] ranks, int cars) {
            long low = 1;
            long high = 1L * cars * cars * Arrays.stream(ranks).max().getAsInt();

            long ans = -1;

            while (low <= high) {
                long mid = low + (high - low) / 2;

                if (isPossible(ranks, mid, cars)) {
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
        int[] ranks = {4, 2, 3, 1};
        int cars = 10;

        Solution obj = new Solution();
        System.out.println(obj.repairCars(ranks, cars));
    }
}
