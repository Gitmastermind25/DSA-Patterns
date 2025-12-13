import java.util.HashMap;

class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;

        // Left pointer
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // If character is already in map, move left pointer
            if (map.containsKey(c)) {
                // Move left to one position after previous index of current character
                left = Math.max(left, map.get(c) + 1);
            }

            // Update the character's latest index
            map.put(c, right);

            // Update max length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = lengthOfLongestSubstring(s);
        System.out.println("Longest substring length: " + result);
    }
}
