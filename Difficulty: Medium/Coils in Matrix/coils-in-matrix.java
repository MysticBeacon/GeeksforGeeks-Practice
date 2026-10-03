import java.util.*;

class Solution {

    public ArrayList<ArrayList<Integer>> formCoils(int n) {

        int N = 4 * n;
        int total = N * N;
        int coilSize = total / 2;

        ArrayList<Integer> coil1 = new ArrayList<>();
        ArrayList<Integer> coil2 = new ArrayList<>();

        // Process each ring
        for (int ring = 0; ring < N / 2; ring++) {

            int top = ring;
            int bottom = N - 1 - ring;
            int left = ring;
            int right = N - 1 - ring;

            /*
             * Even numbered ring:
             *
             * Start from top-left
             * Move DOWN the left column
             * Then move RIGHT along the bottom
             */
            if (ring % 2 == 0) {

                // Move down
                for (int row = top; row <= bottom; row++) {
                    int value = row * N + left + 1;
                    coil1.add(value);
                }

                // Move right
                // Stop before the bottom-right corner
                for (int col = left + 1; col < right; col++) {
                    int value = bottom * N + col + 1;
                    coil1.add(value);
                }

            } else {

                /*
                 * Odd numbered ring:
                 *
                 * Start from bottom-right
                 * Move UP the right column
                 * Then move LEFT along the top
                 */

                // Move up
                for (int row = bottom; row >= top; row--) {
                    int value = row * N + right + 1;
                    coil1.add(value);
                }

                // Move left
                // Stop before the top-left corner
                for (int col = right - 1; col > left; col--) {
                    int value = top * N + col + 1;
                    coil1.add(value);
                }
            }
        }

        // Construct the second coil
        for (int value : coil1) {
            coil2.add(total + 1 - value);
        }

        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

        answer.add(coil1);
        answer.add(coil2);

        return answer;
    }
}