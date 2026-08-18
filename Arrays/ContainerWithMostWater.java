package Arrays;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxWater = 0;
        while (l < r) {
            int width = r-l;
            int h = Math.min(height[l],height[r]);
            int area = width*h;
            maxWater = Math.max(maxWater, area);
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxWater;
    }
    public static void main(String[] args) {

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int result =maxArea(height);

        System.out.println("Maximum Water = " + result);
    }
}

