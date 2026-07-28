package string.basic;

public class AddStrings {

    public static String addStrings(String num1, String num2) {
        StringBuilder ans = new StringBuilder();

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {

            int a = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int b = (j >= 0) ? num2.charAt(j) - '0' : 0;

            int sum = a + b + carry;

            ans.append(sum % 10);
            carry = sum / 10;

            i--;
            j--;
        }

        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "11";
        String num2 = "123";

        String result = addStrings(num1, num2);

        System.out.println("Sum = " + result);
    }
}