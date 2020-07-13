import java.util.HashMap;

public class SubarraySumEqualsK560 {
    public static int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int sum = 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int n : nums){
            sum += n;
            if(map.containsKey(sum - k)){
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;

    }

    public static void main(String[] args) {
        int nums[] = new int[]{1,1,1};
        System.out.println(subarraySum(nums, 2));
    }
}
