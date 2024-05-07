package BinarySearch;

public class leetCode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // find the row
        int u = 0;
        int d = matrix.length - 1;
        int l = 0;
        int r = matrix[0].length - 1;

        while (u <= d) {
            int m = (u + d) / 2;
            if (matrix[m][r] == target)
                return true;
            if (matrix[m][r] > target && matrix[m][l] <= target) {
                // bs in row m
                while (l <= r) {
                    int mid = (l + r) / 2;
                    if (matrix[m][mid] == target)
                        return true;
                    else if (matrix[m][mid] > target)
                        r = mid - 1;
                    else
                        l = mid + 1;
                }
                return false;
            } else if (matrix[m][r] > target) {
                d = m - 1;
            } else if (matrix[m][r] < target) {
                u = m + 1;
            }
        }
        return false;
    }
}
