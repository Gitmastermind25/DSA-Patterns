package string.basic;

public class LargestOddNumber {

    public static String largestOddNumber(String num) {

        for (int i = num.length() - 1; i >= 0; i--) {

            int digit = num.charAt(i) - '0';

            if (digit % 2 == 1) {
                return num.substring(0, i + 1);
            }
        }

        return "";
    }

    public static void main(String[] args) {

        String num = "35427";

        String result = largestOddNumber(num);

        System.out.println("Input: " + num);
        System.out.println("Output: " + result);
    }
}
