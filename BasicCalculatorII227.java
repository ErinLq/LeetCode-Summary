import java.util.Stack;

public class BasicCalculatorII227 {
    public static int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int point = 0;
        int temp = 0;
        int res = 0;
        Character sign = ' ';
        Stack<Integer> stack = new Stack<>();

        while (point < s.length()) {
            char c = s.charAt(point);
            switch (c) {
                case ' ':
                    break;
                case '+':
                    sign = '+';
                    break;
                case '-':
                    sign = '-';
                    break;
                case '*':
                    sign = '*';
                    break;
                case '/':
                    sign = '/';
                    break;
                default:
                    while (point < s.length() && s.charAt(point) >= '0' && s.charAt(point) <= '9') {
                        temp = temp * 10 + s.charAt(point) - '0';
                        point++;
                    }
                    point--;
                    if (stack.isEmpty()) {
                        stack.push(temp);
                    }
                    else {
                        if (sign == '+' || sign == '-') {
                            stack.push((sign == '+') ? temp : -1 * temp);
                        }
                        else {
                            if (sign == '*') {
                                stack.push(stack.pop() * temp);
                            }
                            else {
                                stack.push(stack.pop() / temp);
                            }
                        }
                    }
                    temp = 0;
                    sign = ' ';
                    break;
            }
            point++;
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        String s = " 20* 5 /2 -9";
        System.out.println(calculate(s));
    }
}
