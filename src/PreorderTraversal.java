import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * Created by Yan on 12/8/15.
 */
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return null;
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);
        result.add(root.val);
        if (left != null)
            result.addAll(left);
        if (right != null)
            result.addAll(right);
        return result;
    }

    // non-recursive, use a stack
    public List<Integer> preorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            result.add(temp.val);
            if (temp.right != null)
                stack.push(temp.right);
            if (temp.left != null)
                stack.push(temp.left);
        }
        return result;
    }

    public static void main(String[] args) {
        PreorderTraversal test = new PreorderTraversal();
        Integer[] nums = {1, 2, 3, null, 5, null, null};
        TreeNode root = TreeNode.deserialize(nums);
        List<Integer> result = test.preorder(root);
        System.out.println(result);
    }
}
