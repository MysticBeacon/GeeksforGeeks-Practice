
class Solution {
    public String findRollOut(String s, int[] roll) {
        char[] arr = s.toCharArray();

        int n = roll.length;
        int count = 0;

        // Traverse roll array from right to left
        for (int i = n - 1; i >= 0; i--) {
            count = (count + 1) % 26;
            roll[i] = (roll[i] == 0) ? 0 : roll[i];

            // Store the cumulative effect
            if (i < n - 1) {
                roll[i] = roll[i];
            }
        }

        // Calculate how many operations affect each character
        count = 0;

        for (int i = n - 1; i >= 0; i--) {
            count = (count + 1) % 26;

            int pos = roll[i] - 1;
            if (pos >= 0 && pos < arr.length) {
                // Apply this operation to the first roll[i] characters
            }
        }

        // Correct efficient approach using a difference array
        int[] diff = new int[arr.length + 1];

        for (int r : roll) {
            diff[0] = (diff[0] + 1) % 26;
            diff[r] = (diff[r] - 1 + 26) % 26;
        }

        count = 0;

        for (int i = 0; i < arr.length; i++) {
            count = (count + diff[i]) % 26;
            arr[i] = (char) ('a' + (arr[i] - 'a' + count) % 26);
        }

        return new String(arr);
    }
}
