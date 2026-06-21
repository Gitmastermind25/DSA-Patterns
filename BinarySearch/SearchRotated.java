package BinarySearch;
public class SearchRotated {
    public int findPivot(int[] nums){
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
    public int binarySearch(int l , int r, int[] nums, int target){
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                r = mid -1;
            }else{
                l = mid+1;
            }
        }
        return -1;
    }
    public int search(int[] nums , int target){
        int n = nums.length;
        int pivot = findPivot(nums);
        int idx = binarySearch(0 , pivot-1, nums , target);
        if(idx != -1){
            return idx;
        }
        return binarySearch(pivot, n-1, nums, target);
    }

    static void main() {
        SearchRotated obj = new SearchRotated();
        int[] nums = { 4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int ans = obj.search(nums, target);
        System.out.println(ans);

    }

}

