
import java.util.HashMap;

class Solution {
    int firstElementKTime(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);

            if (count == k) {
                return num;
            }
        }

        return -1;
    }
}
