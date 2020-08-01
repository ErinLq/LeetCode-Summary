import java.util.Arrays;

public class JumpGameII45 {
    public static int jump(int[] nums) {

        int[] res = new int[nums.length];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        int far = 0;

        for(int i = 0; i < res.length; i++){
            if (nums[i] + i > far){
                for(int j = far + 1; j < Math.min(i + nums[i] + 1, res.length); j++){
                    res[j] = Math.min(res[j], res[i] + 1);
                }
            }
            far = i + nums[i];
        }
        return res[res.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(jump(nums));
    }
}
