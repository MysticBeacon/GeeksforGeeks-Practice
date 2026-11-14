
import java.util.*;

class Solution {
    public int maxEqualSum(ArrayList<Integer> s1,
                           ArrayList<Integer> s2,
                           ArrayList<Integer> s3) {

        int sum1 = 0, sum2 = 0, sum3 = 0;

        // Calculate initial sums
        for (int x : s1) sum1 += x;
        for (int x : s2) sum2 += x;
        for (int x : s3) sum3 += x;

        int i = 0, j = 0, k = 0;

        while (true) {

            // Check if all sums are equal
            if (sum1 == sum2 && sum2 == sum3) {
                return sum1;
            }

            // If any stack becomes empty
            if (i == s1.size() ||
                j == s2.size() ||
                k == s3.size()) {
                return 0;
            }

            // Remove from the stack with maximum sum
            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= s1.get(i);
                i++;
            }
            else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= s2.get(j);
                j++;
            }
            else {
                sum3 -= s3.get(k);
                k++;
            }
        }
    }
}
