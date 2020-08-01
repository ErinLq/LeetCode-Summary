public class TrappingRainWater42 {
    // scan for twice
    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] container = new int[height.length];
        int highest = 0;
        int res = 0;
        // from left to right
        for (int i = 0; i < height.length; i++){
            container[i] = highest;
            highest = Math.max(height[i], highest);
        }

        //from right to left
        highest = 0;
        for (int i = height.length - 1; i >= 0; i--){
            container[i] = Math.min(highest, container[i]);
            res += Math.max(container[i] - height[i], 0);
            highest = Math.max(highest, height[i]);
        }
        return res;
    }

    //scan for once
    public static int trap2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int l = 0;
        int r = height.length - 1;
        int res = 0;
        int min = 0;
        while (l < r) {
            min = Math.min(height[l], height[r]);
            if(height[l] == min) {
                l++;
                while (height[l] < min && l < r){
                    res += min - height[l];
                    l++;
                }
            }
            else {
                r--;
                while (height[r] < min && l < r) {
                    res += min - height[r];
                    r--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap2(height));
    }
}
