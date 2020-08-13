package Tree;
import java.util.*;

import java.util.List;

public class BinaryTreeLevelOrderTranversalII107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();

        if (root == null) {
            return res;
        }

        que.offer(root);
        while (!que.isEmpty()) {
            int n = que.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = que.poll();
                list.add(node.val);
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
            res.add(0, list);
        }
        return res;
    }
}
