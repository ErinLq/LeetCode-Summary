import java.lang.reflect.Array;
import java.util.*;

public class PermutationsII47 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        getPermuteUnique(nums, res, temp, used);
        return res;
    }

    public static void getPermuteUnique(int[] nums, List<List<Integer>> res, List<Integer> temp, boolean[] used){
        int n = nums.length;
        if(temp.size() == n){
            res.add(new ArrayList<>(temp));
        }
        else {
//            因为swap以后的nums不再是排好序的了！
//            for(int i = start; i < n; i++){
//                if(i > start && (nums[i] == nums[start] || nums[i] == nums[i - 1])){
//                    continue;
//                }
//                swap(nums, start, i);
//                temp.add(nums[start]);
//                getPermuteUnique(nums, res, temp, start + 1);
//                temp.remove(temp.size() - 1);
//                swap(nums, start, i);
//            }
            for(int i = 0; i < n; i++) {
                if(used[i]){
                    continue;
                }
                /*have used in last round*/
                if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                    continue;
                }
                else{
                    temp.add(nums[i]);
                    used[i] = true;
                    getPermuteUnique(nums, res, temp, used);
                    used[i] = false;
                    temp.remove(temp.size() - 1);
                }
            }
        }

    }

    public static void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        List<List<Integer>> res = permuteUnique(nums);
        for(List<Integer> list : res){
            for(int a : list){
                System.out.print(a);
            }
            System.out.print("\n");
        }
    }
}
