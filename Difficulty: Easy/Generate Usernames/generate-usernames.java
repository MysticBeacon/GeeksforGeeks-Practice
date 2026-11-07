
import java.util.*;

class Solution {
    public ArrayList<String> generateUsernames(String[] arr) {

        HashSet<String> used = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();

        // Reserve all original usernames
        for (String s : arr) {
            used.add(s);
        }

        ArrayList<String> ans = new ArrayList<>();

        for (String name : arr) {

            // First occurrence
            if (!map.containsKey(name)) {
                ans.add(name);
                map.put(name, 1);
            } 
            else {
                int k = map.get(name);

                // Find smallest available suffix
                while (used.contains(name + k)) {
                    k++;
                }

                String newName = name + k;

                ans.add(newName);
                used.add(newName);

                map.put(name, k + 1);
            }
        }

        return ans;
    }
}
