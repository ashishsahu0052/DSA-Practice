public class l844 {

}

class Solution {
    public boolean backspaceCompare(String s, String t) {
        String s1 = check(s);
        String s2 = check(t);

        return s1.equals(s2);

    }

    public String check(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && c == '#') {
                stack.pop();
            } else if (stack.isEmpty() && c == '#') {
                continue;
            } else {
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();

    }
}