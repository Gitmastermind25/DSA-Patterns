package BinarySearch;

import java.util.Arrays;

public class MinimumTimeToCompleteTrips {

    public long minimumTime(int[] time, int totalTrips) {
        long left = 1;
        long right = (long) Arrays.stream(time).min().getAsInt() * totalTrips;

        while (left < right) {
            long mid = left + (right - left) / 2;

            if (possible(time, mid, totalTrips)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean possible(int[] time, long givenTime, int totalTrips) {
        long actualTrips = 0;

        for (int t : time) {
            actualTrips += givenTime / t;

            if (actualTrips >= totalTrips) {
                return true;
            }
        }

        return actualTrips >= totalTrips;
    }

    public static void main(String[] args) {
        int[] time = {1, 2, 3};
        int totalTrips = 5;

        MinimumTimeToCompleteTrips obj = new MinimumTimeToCompleteTrips();
        System.out.println(obj.minimumTime(time, totalTrips));
    }
}
