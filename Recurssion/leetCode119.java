/*
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 */

import java.util.ArrayList;
import java.util.List;

public class leetCode119 {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            List<Integer> ret = new ArrayList<Integer>();
            ret.add(1);
            return ret;
        }

        List<Integer> prevRow = getRow(rowIndex - 1);
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i=1; i<rowIndex; i++) {
            int x = prevRow.get(i-1)+prevRow.get(i);
            row.add(x);
        }
        row.add(1);
        return row;
    }
}
