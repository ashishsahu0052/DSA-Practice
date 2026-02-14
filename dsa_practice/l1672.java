class l1672 {
    public static int maximumWealth(int[][] accounts) {

        int wealth = 0;

        for (int i = 0; i < accounts.length; i++) {
            int newWealth = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                newWealth += accounts[i][j];
            }
            if (newWealth > wealth) {
                wealth = newWealth;
            }
        }

        return wealth;
    }

    public static void main(String[] args) {
        int[][] accounts = {
                { 1, 2 }, { 1, 5, 6, 7 }, { 4, 5, 3 }
        };

        System.out.println(maximumWealth(accounts));
    }
}