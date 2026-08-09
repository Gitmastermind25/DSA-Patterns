package string.basic;

public class RomanToInteger {

    public static int romanToInt(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            int curr = value(s.charAt(i));

            // If current value is smaller than next value, subtract it
            if (i + 1 < s.length() && curr < value(s.charAt(i + 1))) {
                ans -= curr;
            } else {
                ans += curr;
            }
        }

        return ans;
    }

    public static int value(char c) {

        if (c == 'I') return 1;
        if (c == 'V') return 5;
        if (c == 'X') return 10;
        if (c == 'L') return 50;
        if (c == 'C') return 100;
        if (c == 'D') return 500;

        return 1000;
    }

    public static void main(String[] args) {

        String s = "MCMIV";

        System.out.println(romanToInt(s));
    }
}
