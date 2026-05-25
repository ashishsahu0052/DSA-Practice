class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {

        if (n1 == 0) return 0;

        int s1Count = 0;
        int s2Count = 0;
        int index = 0;

        HashMap<Integer, int[]> map = new HashMap<>();

        while (true) {

            s1Count++;

            for (int i = 0; i < s1.length(); i++) {

                if (s1.charAt(i) == s2.charAt(index)) {
                    index++;
                }

                if (index == s2.length()) {
                    s2Count++;
                    index = 0;
                }
            }

            if (s1Count == n1) {
                return s2Count / n2;
            }

            if (map.containsKey(index)) {

                int[] prev = map.get(index);

                int prevS1Count = prev[0];
                int prevS2Count = prev[1];

                int inLoopS1 = s1Count - prevS1Count;
                int inLoopS2 = s2Count - prevS2Count;

                int remainingS1 = n1 - s1Count;

                int loops = remainingS1 / inLoopS1;

                s1Count += loops * inLoopS1;
                s2Count += loops * inLoopS2;

            } else {
                map.put(index, new int[]{s1Count, s2Count});
            }
        }
    }
}