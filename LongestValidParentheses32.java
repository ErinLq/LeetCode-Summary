package DynamicProgramming;

public class LongestValidParentheses32 {
    public static int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;

        int[] res = new int[s.length() + 1];
        res[0] = 0;
        int i = 1;
        int len = 0;
        while(i < s.length() + 1){
            System.out.println(i);
            if(s.charAt(i - 1) == ')'){
                if((i - 1 - res[i - 1] - 1 >= 0) && s.charAt(i - 1 - res[i - 1] - 1) == '('){
                    res[i] = res[i - 1] + 2;
                    res[i] += res[i - res[i]];
                    len = Math.max(len, res[i]);
                }
            }
            i++;
        }
        return len;
    }

    public static void main(String[] args) {
        String s = ")(()";
        System.out.println(longestValidParentheses(s));
    }
}
