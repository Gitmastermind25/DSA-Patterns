package string.basic;

public class AddBinary {

    public static String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {

            int x = (i >= 0) ? a.charAt(i) - '0' : 0;
            int y = (j >= 0) ? b.charAt(j) - '0' : 0;

            int sum = x + y + carry;

            ans.append(sum % 2);
            carry = sum / 2;

            i--;
            j--;
        }

        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "1";

        String result = addBinary(a, b);

        System.out.println("Binary Sum = " + result);
    }
}