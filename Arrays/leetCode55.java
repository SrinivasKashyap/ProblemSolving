public class leetCode55 {
    public boolean canJump(int[] nums) {
        // return util(nums, 0, nums.length);
        int n = nums.length;
        boolean[] dp = new boolean[n];

        for (int i=0; i<n; i++) {
            dp[i]=false;
        }
        dp[n-1] = true;
        for (int i=n-2; i>=0; i--) {
            for (int j=1; j<=nums[i] && j<n; j++) {
                int step = i+j;
                if (dp[step] == true) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}
