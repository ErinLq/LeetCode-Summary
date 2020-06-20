import java.util.*;
public class PathSumⅡ113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        List<Integer> curr = new LinkedList<>();
        getPathSum(root, sum, res, curr);
        return res;
    }

    public void getPathSum(TreeNode root, int sum, List<List<Integer>> res, List<Integer> curr){
        if(root == null) return;

        if(root.left == null && root.right == null){
            if(root.val == sum){
                curr.add(root.val);
                res.add(new LinkedList<>(curr));
                curr.remove(curr.size() - 1);
                return;
            }
            else return;
        }

        else{
            curr.add(root.val);
            getPathSum(root.left, sum - root.val, res, curr);
            getPathSum(root.right, sum - root.val, res, curr);
            curr.remove(curr.size() - 1);
            return;
        }
    }
}
