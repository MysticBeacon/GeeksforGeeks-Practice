import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> socialNetwork(int[] arr) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int n = arr.length + 1;

        // Process users from 2 to n
        for (int i = 2; i <= n; i++) {

            int[] distance = new int[n + 1];

            int current = i;
            int steps = 0;

            // Follow the friend chain
            while (current != 1) {

                current = arr[current - 2];
                steps++;

                distance[current] = steps;
            }

            // j must be in increasing order
            for (int j = 1; j < i; j++) {

                if (distance[j] != 0) {

                    ArrayList<Integer> temp = new ArrayList<>();

                    temp.add(i);
                    temp.add(j);
                    temp.add(distance[j]);

                    result.add(temp);
                }
            }
        }

        return result;
    }
}