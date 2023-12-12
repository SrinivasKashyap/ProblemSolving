package SlidingWindow;

public class leetCode209 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i=0, j=1;
        int sum = nums[i];
        int len = n+1;
        while (i<n) {
            if (sum >= target) {
                int t = (j-i);
                // if (j == n) t = (j-i);
                if (len > t) {
                    len = t;
                }
                sum-=nums[i];
                i++;
            } else {
                if (j>=n) break;
                sum+=nums[j];
                j++;
            }
        }
        if (len == n+1) return 0;
        return len;
    }
}
