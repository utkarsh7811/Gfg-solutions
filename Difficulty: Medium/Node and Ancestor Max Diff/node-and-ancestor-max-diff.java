/* Structure of binary tree node
class Node {
    int data;
    Node left, right;
    Node(int item) {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    int maxDiffVal;

    int maxDiff(Node root) {
        maxDiffVal = Integer.MIN_VALUE;
        solve(root);
        return maxDiffVal;
    }

    private int solve(Node node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        if (node.left == null && node.right == null) {
            return node.data;
        }

        int leftMin = solve(node.left);
        int rightMin = solve(node.right);

        int minDescendant = Math.min(leftMin, rightMin);

        maxDiffVal = Math.max(maxDiffVal, node.data - minDescendant);

        return Math.min(node.data, minDescendant);
    }
}