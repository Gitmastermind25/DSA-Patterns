import java.util.*;
public class ThreeSumCloseTarget {
    public int threeSumCloseTarget(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        int count=0;
        for(int i =0; i<n-2; i++){
            int left=i+1;
            int right=n-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum<target){
                    count+=(right-left);
                    left++;
                }else{
                    right--;
                }
            }
        }
         return count;
    }

    static void main(String[] args) {
        ThreeSumCloseTarget obj = new ThreeSumCloseTarget();
        int[] nums = {-1,0,1,2,-4};
        System.out.println(obj.threeSumCloseTarget(nums, 0));
    }
}
