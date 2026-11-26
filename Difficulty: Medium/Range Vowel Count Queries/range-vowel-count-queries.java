
class Solution {
    public ArrayList<Integer> countVowels(String s, int[][] queries) {
        int n = s.length();

        int[] prefix = new int[n + 1];

        // Build prefix sum array
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i];

            char ch = s.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' ||
                ch == 'o' || ch == 'u') {
                prefix[i + 1]++;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        // Process queries
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            ans.add(prefix[r + 1] - prefix[l]);
        }

        return ans;
    }
}
