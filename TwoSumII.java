import java.util.*;
public static class TwoSumII{
    public int[] twoSum(int[] numbers, int target){
        int i=0;
        int j=numbers.length-1;
        while(i<j){
            int sum= numbers[i]+ numbers[j];
            if(sum == target){
                return new int[]{i+1,j+1};
            }
            if(sum<target){
                i++;
            }else{
                j--;
            }
        }
        return new int[]{};
    }
}
public static void main(String[] args){
    //input from user
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size of array");
    int n = sc.nextInt();

    //Create array of size n
    int[] numbers= new int[n];

    //Take array elements from user
    System.out.println("Enter the sorted array elements");
    for(int i=0; i<n; i++){
        numbers[i]= sc.nextInt();
    }

    //Take target value
    System.out.println("Enter the target number");
    int target = sc. nextInt();

    //Create an object of Solution
    //*“obj is the remote control to access functions inside Solution.”*
    TwoSumII obj = new TwoSumII();

    //Call twoSum() function
    int[] ans = obj.twoSum(numbers,target);

    //Check if solution exists
    if(ans.length>0){
        System.out.println("Indices: " + ans[0]+" "+ans[1]);
    }else{
        System.out.println("No indices");
    }
}