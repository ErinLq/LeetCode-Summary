import java.lang.reflect.Array;
import java.util.*;

public class CombinationSum39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
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
                    temp.add(candidates[i]);
                    combination(candidates, target - candidates[i], i, temp, res);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] can = new int[]{2,3,6,7};
        List<List<Integer>> lists = combinationSum(can, 7);
        for(List<Integer> list : lists){
            for(int n : list){
                System.out.print(n);
            }

            System.out.println("\n");
        }
    }
}
