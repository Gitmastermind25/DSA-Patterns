import java.util.*;

public class RemoveDuplicate {

    // Method returns the new length after removing duplicates
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int officer = 0;

        for (int cm = 1; cm < nums.length; cm++) {
            if (nums[cm] != nums[officer]) {
                officer++;
                nums[officer] = nums[cm];
            }
        }
        return officer + 1;  // new length
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter sorted array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        RemoveDuplicate obj = new RemoveDuplicate();
        int newLength = obj.removeDuplicates(nums);

        System.out.println("New length = " + newLength);
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
