
class Solution {
    public int countEdges(ArrayList<ArrayList<Integer>> adj) {

        int count = 0;

        for (int i = 0; i < adj.size(); i++) {
            count += adj.get(i).size();
        }

        return count / 2;
    }
}
