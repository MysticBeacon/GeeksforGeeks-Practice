
import java.util.*;

class Solution {
    public ArrayList<Integer> lexicographicallyLargest(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();

        for (int x : arr) {
            result.add(x);
        }

        int i = 0;

        while (i < n) {
            int j = i;

            while (j + 1 < n &&
                   result.get(j) % 2 == result.get(j + 1) % 2) {
                j++;
            }

            result.subList(i, j + 1)
                  .sort(Collections.reverseOrder());

            i = j + 1;
        }

        return result;
    }
}
