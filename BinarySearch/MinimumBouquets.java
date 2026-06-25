package BinarySearch;

public class MinimumBouquets {

    public int getNumOfBouquets(int[] bloomDay, int mid, int k) {
        int numOfBouquets = 0;
        int consecutiveCount = 0;

        for (int day : bloomDay) {
            if (day <= mid) {
                consecutiveCount++;
            } else {
                consecutiveCount = 0;
            }

            if (consecutiveCount == k) {
                numOfBouquets++;
                consecutiveCount = 0;
            }
        }

        return numOfBouquets;
    }

    public int minDays(int[] bloomDay, int m, int k) {

        long requiredFlowers = (long) m * k;
        if (requiredFlowers > bloomDay.length) {
            return -1;
        }

        int startDay = 1;
        int endDay = 0;

        for (int day : bloomDay) {
            endDay = Math.max(endDay, day);
        }

        int minDays = -1;

        while (startDay <= endDay) {
            int mid = startDay + (endDay - startDay) / 2;

            if (getNumOfBouquets(bloomDay, mid, k) >= m) {
                minDays = mid;
                endDay = mid - 1;
            } else {
                startDay = mid + 1;
            }
        }

        return minDays;
    }

    public static void main(String[] args) {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3;
        int k = 1;

        MinimumBouquets obj = new MinimumBouquets();
        System.out.println(obj.minDays(bloomDay, m, k));
    }
}