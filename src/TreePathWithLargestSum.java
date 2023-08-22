import java.util.*;

public class TreePathWithLargestSum {
    public static void main(String []args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        List<Integer> maxBranch = findMaxBranch(root);
        System.out.println("Branch with the highest sum: " + maxBranch);
    }

    public static List<Integer> findMaxBranch(TreeNode root) {
        List<Integer> maxBranch = new ArrayList<>();
        List<Integer> currentBranch = new ArrayList<>();

        findMaxBranch(root, currentBranch, maxBranch, 0);

        return maxBranch;
    }

    private static void findMaxBranch(TreeNode node, List<Integer> currentBranch, List<Integer> maxBranch, int currentSum) {
        if (node == null) {
            return;
        }

        // Add the current node's value to the branch sum
        currentSum += node.val;
        currentBranch.add(node.val);

        // If we've reached a leaf node
        if (node.left == null && node.right == null) {
            // Check if this branch has a higher sum than the current max branch
            if (currentSum > sum(maxBranch)) {
                maxBranch.clear();
                maxBranch.addAll(currentBranch);
            }
        } else {
            // Recursively explore the left and right branches
            findMaxBranch(node.left, currentBranch, maxBranch, currentSum);
            findMaxBranch(node.right, currentBranch, maxBranch, currentSum);
        }

        // Remove the current node's value when backtracking
        currentBranch.remove(currentBranch.size() - 1);
    }

    private static int sum(List<Integer> branch) {
        int total = 0;
        for (int val : branch) {
            total += val;
        }
        return total;
    }
}
class Node {
    int val;
    TreeNode left;
    TreeNode right;

    Node() {
    }

    Node(int val) {
        this.val = val;
    }

    Node(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
