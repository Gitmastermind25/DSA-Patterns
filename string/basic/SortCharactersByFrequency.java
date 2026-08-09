package string.basic;

import java.util.*;

public class SortCharactersByFrequency {

    public static String frequencySort(String s) {
        int[] freq = new int[128];

        // Count frequency
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        StringBuilder ans = new StringBuilder();

        // Find highest frequency
        for (int i = 0; i < s.length(); i++) {
            int max = 0;
            char ch = ' ';

            for (char c : s.toCharArray()) {
                if (freq[c] > max) {
                    max = freq[c];
                    ch = c;
                }
            }

            // Add character according to frequency
            while (freq[ch] > 0) {
                ans.append(ch);
                freq[ch]--;
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "tree";

        System.out.println(frequencySort(s));
    }
}
