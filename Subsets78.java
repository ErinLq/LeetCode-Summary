import java.util.*;

public class Subsets78 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i <= nums.length; i++) {
            List<Integer> temp = new ArrayList<>();
            getSubset(nums, res, temp, i, 0);
        }
        return res;
    }

    public static void getSubset(int[] nums, List<List<Integer>> res, List<Integer> temp, int targetSize, int start){
        if(temp.size() == targetSize) {
            res.add(new ArrayList<>(temp));
        }
        else{
            for(int i = start; i < nums.length; i++){
                temp.add(nums[i]);
                getSubset(nums, res, temp, targetSize, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> res = subsets(nums);
        for(List<Integer> list : res){
            for(int n : list){
                System.out.print(n);
            }
            System.out.print("\n");
        }
    }
}
