class Solution {
    ArrayList<Integer> intersection(int[] a, int[] b) {
        ArrayList<Integer> list = new ArrayList<>();

        int i = 0, j = 0;

        while (i < a.length && j < b.length) {

            if (a[i] == b[j]) {
                // avoid duplicates
                if (list.size() == 0 || list.get(list.size() - 1) != a[i]) {
                    list.add(a[i]);
                }
                i++;
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }

        return list;
    }
}