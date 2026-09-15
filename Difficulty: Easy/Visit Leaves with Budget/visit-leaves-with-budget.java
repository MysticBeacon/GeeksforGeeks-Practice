import java.util.*;

class Solution {

    static class Pair {
        Node node;
        int level;

        Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public int getCount(Node root, int k) {

        if (root == null) {
            return 0;
        }

        ArrayList<Integer> leafCosts = new ArrayList<>();

        Queue<Pair> queue = new LinkedList<>();

        // Root is at level 1
        queue.offer(new Pair(root, 1));

        while (!queue.isEmpty()) {

            Pair current = queue.poll();

            Node node = current.node;
            int level = current.level;

            // If this is a leaf node
            if (node.left == null && node.right == null) {
                leafCosts.add(level);
                continue;
            }

            // Add left child
            if (node.left != null) {
                queue.offer(new Pair(node.left, level + 1));
            }

            // Add right child
            if (node.right != null) {
                queue.offer(new Pair(node.right, level + 1));
            }
        }

        // Cheapest leaves first
        Collections.sort(leafCosts);

        int count = 0;
        int totalCost = 0;

        for (int cost : leafCosts) {

            if (totalCost + cost > k) {
                break;
            }

            totalCost += cost;
            count++;
        }

        return count;
    }
}