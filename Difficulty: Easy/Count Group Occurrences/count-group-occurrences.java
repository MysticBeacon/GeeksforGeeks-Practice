
class Solution {
    int getCount(String s, int k) {
        int[] freq = new int[26];

        // Count the number of groups for each character
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i) != s.charAt(i - 1)) {
                freq[s.charAt(i) - 'a']++;
            }
        }

        // Count characters appearing in exactly k groups
        int ans = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] == k) {
                ans++;
            }
        }

        return ans;
    }
}
