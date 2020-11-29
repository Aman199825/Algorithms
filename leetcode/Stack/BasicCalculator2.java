class BasicCalculator2 {
    public int calculate(String s) {
        int num = 0;
        s = s.replaceAll(" ", "");
        Stack<Integer> stack = new Stack<>();
        char op = '+';
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            } else {
                if (op == '+') {
                    stack.push(num);
                } else if (op == '-') {
                    stack.push(-num);
                } else if (op == '*') {
                    stack.push(stack.pop() * num);
                } else if (op == '/') {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                op = ch;
            }
        }
        if (op == '+') {
            stack.push(num);
        } else if (op == '-') {
            stack.push(-num);
        } else if (op == '*') {
            stack.push(stack.pop() * num);
        } else if (op == '/') {
            stack.push(stack.pop() / num);
        }

        int res = 0;
        for (int i : stack)
            res += i;
        return res;
    }
}