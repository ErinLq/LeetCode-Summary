package DynamicProgramming;

public class MaximumProductSubarray152 {
    public static int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int minValue = nums[0], maxValue = nums[0];
        int res = nums[0];

        for(int i = 1; i < nums.length; i++){
            //swap min and max
            if(nums[i] < 0){
                int temp = minValue;
                minValue = maxValue;
                maxValue = temp;
            }
            maxValue = Math.max(nums[i], maxValue * nums[i]);
            minValue = Math.min(nums[i], minValue * nums[i]);
            res = Math.max(res, maxValue);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,3,-5};
        System.out.println(maxProduct(nums));
    }
}
