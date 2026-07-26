package string.basic;

public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {

        int i = s.length() - 1;
        int length = 0;

        // Skip spaces at the end
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Count last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }

    public static void main(String[] args) {
        String s = "Hello World";

        System.out.println(lengthOfLastWord(s));
    }
}
