import java.util.ArrayList;
import java.util.List;

public class MajorityElementII229 {
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        //Moore Voting
        //该元素的出现次数大于其余所有元素出现次数的和
        int count1 = 0, count2 = 0;
        int cand1 = -1, cand2 = -1;
        for(int n : nums){
            System.out.println(cand1);
            System.out.println(cand2);
            if(n == cand1) {
                count1++;
            }
            else if(n == cand2) {
                count2++;
            }
            else if(count1 == 0){
                count1++;
                cand1 = n;
            }
            else if(count2 == 0){
                count2++;
                cand2 = n;
            }
            else{
                count1--;
                count2--;
            }
        }


        count1 = 0;
        count2 = 0;
        for(int n : nums){
            if(n == cand1) count1++;
            if(n == cand2) count2++;
        }
        if(count1 > nums.length/3) res.add(cand1);
        if(count2 > nums.length/3) res.add(cand2);
        return res;
    }
}
