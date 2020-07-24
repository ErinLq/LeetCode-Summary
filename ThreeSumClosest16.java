import java.util.Arrays;
import java.util.Enumeration;

public class ThreeSumClosest16 {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int res = Integer.MAX_VALUE;
        int sum = target;

        for (int i = 0; i < nums.length; i++){
            int left = i + 1;
            int right = nums.length - 1;

            int k = target - nums[i];

            while (left < right){
                if (left > i + 1 && nums[left] == nums[left - 1]){
                    left++;
                    continue;
                }
                if (right < nums.length - 1 && nums[right] == nums[right + 1]){
                    right--;
                    continue;
                }
                if (nums[left] + nums[right] == k){
                    return target;
                }
                else if (nums[left] + nums[right] > k){
                    if(Math.abs(target - (nums[left] + nums[right] + nums[i])) < res){
                        res = Math.abs(target - (nums[left] + nums[right] + nums[i]));
                        sum = nums[left] + nums[right] + nums[i];
                    }
                    right--;
                }
                else {
                    if(Math.abs(target - (nums[left] + nums[right] + nums[i])) < res){
                        res = Math.abs(target - (nums[left] + nums[right] + nums[i]));
                        sum = nums[left] + nums[right] + nums[i];
                    }
                    left++;
                }

            }
        }
        return sum;
    }

}
