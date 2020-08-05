import java.util.Stack;

public class BasicCalculatorIII772 {
    public static int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int point = 0;
        int temp = 0;
        char sign = '+';
        int res = 0;

        Stack<Object> stack = new Stack<>();

        while (point < s.length()) {
            char c = s.charAt(point);
            switch (c) {
                case ' ':
                    break;
                case '(':
                    stack.push(sign);
                    stack.push('(');
                    sign = '+';
                    break;
                case ')':
                    while (!stack.isEmpty() && !stack.peek().equals('(')) {
                        temp += (Integer)stack.pop();
                    }
                    stack.pop();
                    if (!stack.isEmpty()){
                        char t = (Character) stack.pop();
                        switch (t) {
                            case '+':
                                stack.push(temp);
                                break;
                            case '-':
                                stack.push(-temp);
                                break;
                            case '*':
                                stack.push((int)stack.pop() * temp);
                                break;
                            case '/':
                                stack.push((int)stack.pop() / temp);
                                break;
                        }
                        temp = 0;
                    }

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
                    } else {
                        if (sign == '+' || sign == '-') {
                            stack.push((sign == '+') ? temp : -1 * temp);
                        } else {
                            if (sign == '*') {
                                stack.push((int)stack.pop() * temp);
                            } else {
                                stack.push((int)stack.pop() / temp);
                            }
                        }
                    }
                    temp = 0;
                    sign = '+';
                    break;
            }
            point++;
        }
        while (!stack.isEmpty()) {
            res += (int)stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "2*(5+5*2)/3+(6/2+8)";
        System.out.println(calculate(s));
    }
}
