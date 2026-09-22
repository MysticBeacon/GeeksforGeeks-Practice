import java.util.*;

class Solution {

    public String findLongestWord(String s, List<String> d) {

        // Store positions of every character
        ArrayList<Integer>[] positions = new ArrayList[26];

        for (int i = 0; i < 26; i++) {
            positions[i] = new ArrayList<>();
        }

        for (int i = 0; i < s.length(); i++) {
            positions[s.charAt(i) - 'a'].add(i);
        }

        String answer = "";

        for (String word : d) {

            if (isSubsequence(word, positions)) {

                if (word.length() > answer.length() ||
                    (word.length() == answer.length()
                     && word.compareTo(answer) < 0)) {

                    answer = word;
                }
            }
        }

        return answer;
    }

    private boolean isSubsequence(
            String word,
            ArrayList<Integer>[] positions) {

        int prev = -1;

        for (int i = 0; i < word.length(); i++) {

            int ch = word.charAt(i) - 'a';

            ArrayList<Integer> list = positions[ch];

            // Find first position > prev
            int left = 0;
            int right = list.size() - 1;
            int found = -1;

            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (list.get(mid) > prev) {
                    found = list.get(mid);
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            // Character cannot be matched
            if (found == -1) {
                return false;
            }

            prev = found;
        }

        return true;
    }
}