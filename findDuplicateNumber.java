public class findDuplicateNumber {

    public static int findDuplicateNumber(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Step 1: Detect cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Step 2: Find the duplicate number
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        // Input array
        int[] nums = {3, 1, 3, 2, 4};

        // Function call
        int duplicate = findDuplicateNumber(nums);

        // Output
        System.out.println("Duplicate number is: " + duplicate);
    }
}
