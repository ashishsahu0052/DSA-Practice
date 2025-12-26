class Solution {
    public int bestClosingTime(String customers) {
        int prefixN = 0;
        int suffixY = 0;

        // Count total Y
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y')
                suffixY++;
        }

        int penalty = suffixY;
        int penaltyIndex = 0;

        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y')
                suffixY--;
            else
                prefixN++;

            if (prefixN + suffixY < penalty) {
                penalty = prefixN + suffixY;
                penaltyIndex = i + 1;
            }
        }
        return penaltyIndex;
    }
}
