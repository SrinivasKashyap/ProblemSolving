package HashMap;

import java.util.Arrays;

public class leetCode128 {
        public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n==0) return 0;
        Arrays.sort(nums);

        int len = 1;
        int max = 1;
        for (int i=0; i<n-1; i++) {
            if (nums[i] == (nums[i+1] - 1)) {
                len++;
            } else if (nums[i] == nums[i+1]) continue;
             else {
                if (len > max) max = len;
                len=1;
            }
        }
        if (len > max) max = len;
        return max;
    }
}
