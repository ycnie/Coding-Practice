class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * number;
                sign = 1;
                number = 0;
            } else if (c == '-') {
                result += sign * number;
                sign = -1;
                number = 0;
            } else if (c == '(') {
                stack.offerFirst(result);
                stack.offerFirst(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * number;
                sign = stack.pollFirst();
                result = sign * result + stack.pollFirst();
                number = 0;
            }
        }
        if (number != 0) {
            result += sign * number;
        }
        return result;
    }
}