package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class leetCode56 {
        public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        //Sort intervals in ascending order based on intervals[i][0]
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        for (int i=0; i<intervals.length-1; i++) {
            if (canMerge(intervals[i], intervals[i+1])) {
                int[] temp = merge(intervals[i], intervals[i+1]);
                intervals[i+1][0] = temp[0];
                intervals[i+1][1] = temp[1];
            } else {
                result.add(intervals[i]);
            }
        }
        result.add(intervals[intervals.length - 1]);
        return result.toArray(new int[result.size()][2]);
    }

    public boolean canMerge(int[] a, int[] b) {
        if (a[1] >= b[0]) return true;
        return false;
    }

    public int[] merge(int[] a, int[] b) {
        int result[] = new int[2];
        result[0] = a[0];
        if (a[1] >= b[1]) {
            result[1] = a[1];
        } else {
            result[1] = b[1];
        }
        return result;
    }
}
