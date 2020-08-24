package Tree;


import java.util.Stack;

public class ConstructBinaryTreefromString536 {

    public TreeNode str2tree(String s) {
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            if (s.charAt(i) == ')') {
                stack.pop();
            }
            if (s.charAt(i) == '-' || Character.isDigit(s.charAt(i))) {
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i))) {
                    i++;
                }
                int value = Integer.valueOf(s.substring(j, i + 1));
                TreeNode node = new TreeNode(value);
                if (!stack.isEmpty()) {
                    if (stack.peek().left != null) {
                        stack.peek().right = node;
                    }
                    else {
                        stack.peek().left = node;
                    }
                }
                stack.push(node);
            }

        }
        return (stack.isEmpty()) ? null : stack.pop();
    }
}
