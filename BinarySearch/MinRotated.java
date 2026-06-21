package BinarySearch;

public class MinRotated {
    public int findMin(int[] nums){
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int mid = l + (r-l)/2;
            if(nums[mid] > nums[r]){
                l = mid +1;
            }else{
                r= mid;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        MinRotated obj = new MinRotated();

        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        int ans = obj.findMin(nums);

        System.out.println(ans);
    }
}
