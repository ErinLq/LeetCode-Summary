import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DifferentWaystoAddParentheses241 {

    public List<Integer> diffWaysToCompute(String input) {

        List<Integer> res = new ArrayList<>();
        if(input == null || input.length() == 0){
            return new ArrayList<>();
        }

        else {
            for(int i = 0; i < input.length(); i++){
                char c = input.charAt(i);
                if(c == '+' || c == '-' || c == '*'){
                    List<Integer> pre = diffWaysToCompute(input.substring(0,i));
                    List<Integer> post = diffWaysToCompute(input.substring(i + 1));

                    for (int x : pre){
                        for (int y : post){
                            if (c == '+'){
                                res.add(x + y);
                            }
                            else if (c == '-'){
                                res.add(x - y);
                            }
                            else {
                                res.add(x * y);
                            }
                        }
                    }
                }
            }
            if(res.size() == 0){
                res.add(Integer.parseInt(input));
            }
        }
        return res;
    }
}
