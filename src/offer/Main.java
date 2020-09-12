package offer;

import java.util.Stack;

public class Main {
    public void test() {
        int T = 4;
        String[] orders = new String[]{" (- 0 (+ 1 3))", " (+2 20)", "+  1 2)", "  2 2"};
        for (int i = 0; i < T; i++) {
            String order = orders[i].trim();
            Stack<String> stack = new Stack<>();
            int j = 0;
            while (j < order.length()) {
                if (order.charAt(j) == '(' || order.charAt(j) == ')' || order.charAt(j) == '+' || order.charAt(j) == '-' || order.charAt(j) == '*') {
                    if (order.charAt(j) == ')') {
                        int arg2 = Integer.parseInt(stack.pop());
                        int arg1 = Integer.parseInt(stack.pop());
                        String op = stack.pop();
                        if (stack.isEmpty() || (!op.equals("+") && !op.equals("-") && !op.equals("*"))) {
                            break;
                        }
                        if (stack.isEmpty() || !stack.pop().equals("(")) {
                            break;
                        }
                        if (op.equals("+")) {
                            stack.push(Integer.toString(arg1 + arg2));
                        } else if (op.equals("-")) {
                            stack.push(Integer.toString(arg1 - arg2));
                        } else if (op.equals("*")) {
                            stack.push(Integer.toString(arg1 * arg2));
                        }
                        j++;
                        continue;
                    }
                    stack.push(order.substring(j, j + 1));
                    j++;
                    continue;
                }
                if (order.charAt(j) == ' ') {
                    j++;
                    continue;
                }
                String arg = "";
                while (j < order.length() && 48 <= order.charAt(j) && order.charAt(j) <= 57) {
                    arg = arg + order.charAt(j);
                    j++;
                }
                stack.push(arg);

            }
            if (stack.size() == 1) {
                System.out.println((Integer.parseInt(stack.pop()) % 10000000 + 10000000) % 10000000);
            } else {
                System.out.println("invalid");
            }

        }
    }

    public static void main(String[] args) {
        new Main().test();
    }
}
