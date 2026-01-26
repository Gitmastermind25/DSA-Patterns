import java.util.HashMap;

public class ContiguousArray {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 1, 0, 0};

        int result = findMaxLength(nums);
        System.out.println("Maximum length = " + result);
    }

    public static int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // prefix sum 0 at index -1

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 0) ? -1 : 1;

            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}
