package string.basic;

public class MaximumNestingDepth {

    public static int maxDepth(String s) {
        int p = 0;
        int ans = 0;

        for (char ch : s.toCharArray()) {

            // Increase depth on '('
            if (ch == '(') {
                p++;
            }

            // Decrease depth on ')'
            else if (ch == ')') {
                p--;
            }

            // Store maximum depth
            ans = Math.max(ans, p);
        }

        return ans;
    }

    public static void main(String[] args) {

        String s = "(1+(2*3)+((8)/4))+1";

        System.out.println(maxDepth(s));
    }
}