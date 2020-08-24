package MergeIntervals;

import java.util.LinkedList;

public class InsertInterval57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][] {newInterval};
        }

        //mark if newInterval has been inserted
        boolean flag = false;
        LinkedList<int[]> lists = new LinkedList<>();

        for (int[] inter: intervals) {
            //the new interval has been inserted
            if (flag) {
                if (lists.getLast()[1] >= inter[0]) {
                    lists.getLast()[1] = Math.max(lists.getLast()[1], inter[1]);
                }
                else {
                    lists.add(inter);
                }
            }

            //the new interval has not been inserted
            else {
                // no overlap
                if (inter[1] < newInterval[0]) {
                    lists.add(inter);
                }
                else if (newInterval[1] < inter[0]) {
                    lists.add(newInterval);
                    lists.add(inter);
                    flag = true;
                }

                //overlapping
                else {
                    lists.add(new int[] {Math.min(inter[0], newInterval[0]), Math.max(inter[1], newInterval[1])});
                    flag = true;
                }
            }
        }
        if (!flag) {
            lists.add(newInterval);
        }
        return lists.toArray(new int[lists.size()][]);
    }
}
