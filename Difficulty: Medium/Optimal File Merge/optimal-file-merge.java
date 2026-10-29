import java.util.PriorityQueue;

class Solution {
    public int minComputation(int[] files) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add all file sizes to the min-heap
        for (int file : files) {
            pq.offer(file);
        }

        int totalCost = 0;

        // Merge the two smallest files until one remains
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            int merged = first + second;
            totalCost += merged;

            pq.offer(merged);
        }

        return totalCost;
    }
}