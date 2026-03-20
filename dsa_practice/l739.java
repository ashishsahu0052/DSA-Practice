
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];

        for (int day = 0; day < temperatures.length; day++) {

            while (!stack.isEmpty() && temperatures[day] > temperatures[stack.peek()]) {
                int rem = day - stack.peek();
                result[stack.peek()] = rem;
                stack.pop();
            }
            stack.push(day);
        }
        return result;
    }
}