class l1295 {
    public static int findNumbers(int[] nums) {
        int count = 0;

        for (int i : nums) {
            if (isEvenDigit(i)) {
                count++;
            }
        }

        return count;
    }

    // checking even number of digit
    public static boolean isEvenDigit(int num) {
        return digit(num) % 2 == 0;
    }
    // conting digit
    /*
     * public int digit(int num ){
     * int sum = 0;
     * 
     * if(num == 0)return 1;
     * if(num < 0){
     * num = num * -1;
     * 
     * }
     * 
     * while(num > 0){
     * sum++;
     * num /= 10;
     * }
     * return sum ;
     * }
     */

    // counting digit 2

    public static int digit(int num) {
        if (num < 0)
            num *= -1;

        return (int) (Math.log10(num)) + 1;
    }

    public static void main(String[] args) {
        int[] nums = { 123, 1232, 43, -122, 3423, 4 };
        System.out.println(findNumbers(nums));

    }
}