
class Solution {
    int minDiff(Node root, int k) {
        int ans = Integer.MAX_VALUE;

        while (root != null) {
            ans = Math.min(ans, Math.abs(root.data - k));

            if (ans == 0) {
                return 0;
            }

            if (k < root.data) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return ans;
    }
}
