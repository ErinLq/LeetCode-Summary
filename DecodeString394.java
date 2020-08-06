import java.util.Stack;

public class DecodeString394 {
    public static String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int point = 0;
        Stack<Integer> count = new Stack<>();
        Stack<String> stack = new Stack<>();
        StringBuilder str = new StringBuilder();
        while (point < s.length()) {
            char c = s.charAt(point);
            if (Character.isDigit(c)) {
                int times = 0;
                while (point < s.length() && Character.isDigit(s.charAt(point))) {
                    times = times * 10 + s.charAt(point) - '0';
                    point++;
                }
                point--;
                count.push(times);
            }
            else if (c == '[') {
                stack.push(str.toString());
                str.replace(0, str.length(), "");
            }
            else if (c == ']') {
                StringBuilder res = new StringBuilder(stack.pop());
                int n = count.pop();
                str = res.append(str.toString().repeat(n));
            }
            else {
                str.append(c);
            }
            point++;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String s = "a2[s2[c]]ab2[d]";
        System.out.println(decodeString(s));
    }
}
