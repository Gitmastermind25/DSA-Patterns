package Arrays;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums){
        int n =nums.length;
        int i=0;
        int j =1;
        while(j<n){
            if(nums[i]!=nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i+1;
    }
    public static void main(String[] args) {
        RemoveDuplicates obj = new RemoveDuplicates();
        int[] nums = {1, 1, 2, 2, 3};
        int k = obj.removeDuplicates(nums);
        System.out.println("Unique elements: " + k);
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
