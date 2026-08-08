package string.basic;

public class RemoveOuterParentheses {

    public static String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int count = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {
                count++;

                if (count > 1) {
                    ans.append(c);
                }

            } else {
                count--;

                if (count > 0) {
                    ans.append(c);
                }
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        String s = "(()())(())";

        System.out.println("Input: " + s);
        System.out.println("Output: " + removeOuterParentheses(s));
    }
}