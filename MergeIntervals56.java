package MergeIntervals;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals56 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return intervals;
        }

        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
            else {
                return o1[0] - o2[0];
            }

        });

        LinkedList<int[]> list = new LinkedList<>();
        for (int[] inter : intervals) {
            if (list.isEmpty()) {
                list.add(inter);
            }
            else {
                //overlap
                if (list.getLast()[1] < inter[0]) {
                    list.add(inter);
                }
                else {
                    list.getLast()[1] = Math.max(list.getLast()[1], inter[1]);
                }
            }
        }

        return list.toArray(new int[list.size()][]);
    }



}
