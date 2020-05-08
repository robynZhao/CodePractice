import java.util.*;

public class CousinsInBinaryTree_993 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        root.left = new TreeNode();
        root.left.val = 2;
        root.right = new TreeNode();
        root.right.val = 3;
        root.left.right = new TreeNode();
        root.left.right.val = 4;
        root.right.right = new TreeNode();
        root.right.right.val = 5;
        int x = 5;
        int y = 4;
        boolean result = isCousins(root, x, y);
        System.out.println(result);
    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        // Level order traversal of a tree is breadth first traversal for the tree
        // travelTree return [parentValue, depth]

        if(root != null) {
            int[] targetXResult = getParentDepth(null, root, x, 1);
            int[] targetYResult = getParentDepth(null, root, y, 1);

            if(targetXResult[0] != targetYResult[0] && targetXResult[1] == targetYResult[1]) {
                return true;
            }
        }

        return false;
    }

    public static int[] getParentDepth(TreeNode parent, TreeNode root, int target, int depth) {
        int result[] = new int[2];

        travelTree(parent, root, target, depth, result);

        return result;
    }

    public static void travelTree(TreeNode parent, TreeNode root, int target, int depth, int[] result) {
        if(root.val == target) {
            result[0] = parent.val;
            result[1] = depth;
        } else if(root != null && (root.left != null || root.right != null)) {
            if(root.left != null) {
                travelTree(root, root.left, target, depth + 1, result);
            }
            if(root.right != null) {
                travelTree(root, root.right, target, depth + 1, result);
            }
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
