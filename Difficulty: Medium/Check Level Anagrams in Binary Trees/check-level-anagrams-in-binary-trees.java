import java.util.*;

class Solution {

    public boolean areAnagrams(Node root1, Node root2) {

        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        q1.add(root1);
        q2.add(root2);

        while (!q1.isEmpty() && !q2.isEmpty()) {

            // Number of nodes at current level
            int size1 = q1.size();
            int size2 = q2.size();

            // If number of nodes at this level differs
            if (size1 != size2)
                return false;

            HashMap<Integer, Integer> freq1 = new HashMap<>();
            HashMap<Integer, Integer> freq2 = new HashMap<>();

            // Process level of tree 1
            for (int i = 0; i < size1; i++) {

                Node current = q1.poll();

                freq1.put(
                    current.data,
                    freq1.getOrDefault(current.data, 0) + 1
                );

                if (current.left != null)
                    q1.add(current.left);

                if (current.right != null)
                    q1.add(current.right);
            }

            // Process level of tree 2
            for (int i = 0; i < size2; i++) {

                Node current = q2.poll();

                freq2.put(
                    current.data,
                    freq2.getOrDefault(current.data, 0) + 1
                );

                if (current.left != null)
                    q2.add(current.left);

                if (current.right != null)
                    q2.add(current.right);
            }

            // Compare frequencies
            if (!freq1.equals(freq2))
                return false;
        }

        // Both trees should finish together
        return q1.isEmpty() && q2.isEmpty();
    }
}