package Tree;

import java.util.*;


public class AverageofLevelsinBinaryTree637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new LinkedList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if (root == null) {
            return res;
        }
        que.offer(root);
        while (!que.isEmpty()) {
            // The amount of tree node on this level
            int n = que.size();
            double sum = 0;
            for (int i = 0; i < n; i++) {
                TreeNode node = que.poll();
                sum += node.val;
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
            res.add(sum / n);
        }
        return res;
    }
}
