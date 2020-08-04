import java.util.Stack;

public class BasicCalculator224 {
    public static int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int point = 0;
        int sign = 1;
        int temp = 0;
        int res = 0;
        Stack stack = new Stack();
        while (point < s.length()) {
            char c = s.charAt(point);
            switch (c) {
                case ' ' :
                    break;
                case '(' :
                    stack.push((sign == 1) ? '+' : '-');
                    sign = 1;
                    break;
                case '+' :
                    break;
                case '-' :
                    sign = -1;
                    break;
                case ')' :
                    while (!(stack.peek().equals('+') || stack.peek().equals('-'))) {
                        temp += (Integer)stack.pop();
                    }
                    // pop '('
                    sign = (stack.pop().equals('+')) ? 1 : -1;
                    stack.push(sign * temp);
                    temp = 0;
                    sign = 1;
                    break;
                default :
                    while (point < s.length() && s.charAt(point) >= '0' && s.charAt(point) <= '9') {
                        System.out.println(s.charAt(point) - '0');
                        temp = temp * 10 + (s.charAt(point) - '0');
                        point++;
                    }
                    point--;
                    stack.push(sign * temp);
                    sign = 1;
                    temp = 0;
                    break;
            }
            point++;
        }
        while (!stack.isEmpty()) {
            res += (int)stack.pop();
        }
        return res;
    }
    
}
