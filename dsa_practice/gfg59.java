class Solution {
    public ArrayList<Integer> constructList(int[][] queries) {

        ArrayList<Integer> ans = new ArrayList<>();
        int xr = 0;

        for (int i = queries.length - 1; i >= 0; i--) {

            if (queries[i][0] == 1) {
                xr ^= queries[i][1];
            } else {
                ans.add(queries[i][1] ^ xr);
            }
        }

        ans.add(xr); // initial 0 becomes 0 ^ xr

        Collections.sort(ans);
        return ans;
    }
}