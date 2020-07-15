import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII40 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //backpack problem

        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();

        if(candidates == null || candidates.length == 0) return res;

        List<Integer> temp = new ArrayList<>();
        combination(candidates, target, 0, temp, res);
        return res;
    }

    public static void combination(int[] candidates, int target, int start, List<Integer>temp, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(temp));
        }
        else if(target > 0){
            for(int i = start; i < candidates.length; i++){
                if(target < candidates[i]) break;
                else {
                    if(i > start && candidates[i] == candidates[i - 1]) continue;
                    temp.add(candidates[i]);
                    combination(candidates, target - candidates[i], i + 1, temp, res);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] can = new int[]{1,1,5,6,7};
        combinationSum2(can, 8);
    }
}
