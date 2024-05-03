package BinarySearch;

public class leetCode35 {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = (l + r + 1) / 2;
            if (nums[m] == target)
                return m;
            else if (nums[m] > target) {
                if (m > 0 && nums[m - 1] < target)
                    return m;
                r = m - 1;
            } else {
                if (m < nums.length - 1 && nums[m + 1] > target)
                    return m + 1;
                l = m + 1;
            }
        }
        if (target > nums[nums.length - 1])
            return nums.length;
        else
            return 0;
    }
}
