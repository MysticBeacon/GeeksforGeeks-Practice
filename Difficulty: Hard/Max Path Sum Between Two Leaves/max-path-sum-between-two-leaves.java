class Solution {

    int maxSum = Integer.MIN_VALUE;

    static class Info {
        int sum;       // Maximum sum from this node to a leaf
        int leafCount; // Number of leaves in this subtree

        Info(int sum, int leafCount) {
            this.sum = sum;
            this.leafCount = leafCount;
        }
    }

    public int maxPathSum(Node root) {
        if (root == null) {
            return -1;
        }

        Info result = solve(root);

        // Fewer than 2 leaves => no leaf-to-leaf path
        if (result.leafCount < 2) {
            return -1;
        }

        return maxSum;
    }

    private Info solve(Node node) {

        // Leaf node
        if (node.left == null && node.right == null) {
            return new Info(node.data, 1);
        }

        // Only right child
        if (node.left == null) {
            Info right = solve(node.right);

            return new Info(
                node.data + right.sum,
                right.leafCount
            );
        }

        // Only left child
        if (node.right == null) {
            Info left = solve(node.left);

            return new Info(
                node.data + left.sum,
                left.leafCount
            );
        }

        // Both children exist
        Info left = solve(node.left);
        Info right = solve(node.right);

        // A valid leaf-to-leaf path passes through this node
        maxSum = Math.max(
            maxSum,
            left.sum + node.data + right.sum
        );

        // Return the best downward path
        int bestDown = node.data + Math.max(left.sum, right.sum);

        return new Info(
            bestDown,
            left.leafCount + right.leafCount
        );
    }
}