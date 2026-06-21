package BinarySearch;

public class FloorCeil {
    public int floor(int[] nums, int target){
        int l = 0;
        int h = nums.length-1;
        int ans = -1;
        while(l<=h){
            int mid = l + (h-l)/2;
            if(nums[mid] <=target){
                ans = nums[mid];
                l = mid + 1;
            }else {
                h = mid -1;
            }
        }
        return ans;
    }
    public int ceil(int[] nums, int target){
        int l = 0;
        int h = nums.length-1;
        int ans = -1;
        while(l<=h){
            int mid = l + (h-l)/2;
            if (nums[mid] >= target){
                ans = nums[mid];
                h = mid -1;
            }else{
                l = mid +1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FloorCeil obj = new  FloorCeil();

        int[] nums = { 10, 20, 30, 40, 50 };
        int target = 25;
        int floor = obj.floor(nums, target);
        int ceil = obj.ceil(nums, target);

        System.out.println("Floor = " + floor);
        System.out.println("Ceil = " + ceil);


    }
}
