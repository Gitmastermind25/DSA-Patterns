package BinarySearch;

import java.util.Arrays;

public class KokoEatingBananas {

    public boolean canEatAll(int[] piles, int givenHours, int h) {
        int actualHours = 0;

        for (int x : piles) {
            actualHours += x / givenHours;

            if (x % givenHours != 0) {
                actualHours++;
            }
        }

        return actualHours <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (canEatAll(piles, mid, h)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return r;
    }

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;

        KokoEatingBananas obj = new KokoEatingBananas();
        System.out.println(obj.minEatingSpeed(piles, h));
    }
}