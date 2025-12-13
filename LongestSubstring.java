import java.util.HashMap;
import java.util.Map;

public class LongestKSubstring {

    // Function to find the length of the longest substring with exactly k unique characters
    public int longestKSubstr(String s, int k) {
        int n = s.length();
        int low = 0, res = -1;  // low = left pointer, res = max length
        Map<Character, Integer> freq = new HashMap<>(); // stores frequency of characters in window

        for (int high = 0; high < n; high++) {
            char c = s.charAt(high);
            freq.put(c, freq.getOrDefault(c, 0) + 1); // add current char to the window

            // shrink window from left if unique characters > k
            while (freq.size() > k) {
                char leftChar = s.charAt(low);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar); // remove char if count becomes 0
                }
                low++;
            }

            // if exactly k unique, update result
            if (freq.size() == k) {
                res = Math.max(res, high - low + 1);
            }
        }

        return res; // return length of longest substring with exactly k unique characters
    }

    // Main method to test
    public static void main(String[] args) {
        LongestKSubstring obj = new LongestKSubstring();
        String s = "aabacbebebe";
        int k = 3;
        System.out.println("Length of longest substring with " + k + " unique characters: "
                + obj.longestKSubstr(s, k));
    }
}
