import java.util.*;
public class LengthOfLongestSubstring {
    public static int lengthOflongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int low =0, maxLen=0;
        int n = s.length();
        for(int high=0;high<n;high++){
            char c = s.charAt(high);
            if(map.containsKey(c)){
                low = Math.max(low, map.get(c)+1);
            }
            map.put(c,high);
            maxLen= Math.max(maxLen, high-low+1);
        }
        return maxLen;
    }

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String s = sc.nextLine();

       System.out.println("Length of Longest substring without repeating character: " + lengthOflongestSubstring(s));

        sc.close();

    }
}