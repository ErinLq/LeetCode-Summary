package Recursion;
import java.util.*;

public class OutputContestMatches544 {
    public String findContestMatch(int n){
        int k = (int)(Math.log(n)/Math.log(2.0));
        //If n <= 1, no return.
        if(k == 0){
            return Integer.toString(1);
        }
        else{
            ArrayList<String> temp = new ArrayList<>();
            for(int i = 1; i <= n; i++){
                temp.add(String.valueOf(i));
            }
            return merge(temp, k);
        }
    }
    public static String merge(ArrayList<String> temp, int k){
        if(k == 0){
            return temp.get(0);
        }
        else {
            ArrayList<String> temp0 = new ArrayList<>();
            for(int i = 0; i < temp.size()/2; i++){
                String t = '(' + temp.get(i) + ',' + temp.get(temp.size() - 1 - i) + ')';
                temp0.add(t);
            }
            temp = temp0;
            k--;
            return merge(temp, k);
        }

    }
}
