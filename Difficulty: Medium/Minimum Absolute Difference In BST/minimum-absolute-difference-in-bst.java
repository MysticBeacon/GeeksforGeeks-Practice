class Solution {

    int minDiff = Integer.MAX_VALUE;
    int prev = -1;

    public int absDiff(Node root) {
        inorder(root);
        return minDiff;
    }

    private void inorder(Node root) {

        if (root == null) {
            return;
        }

        // Left subtree
        inorder(root.left);

        // Compare current node with previous node
        if (prev != -1) {
            minDiff = Math.min(minDiff, root.data - prev);
        }

        // Update previous value
        prev = root.data;

        // Right subtree
        inorder(root.right);
    }
}