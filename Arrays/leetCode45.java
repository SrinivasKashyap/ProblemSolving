public class leetCode45 {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i=0; i<n; i++) dp[i]=-1;
        dp[n-1] = 0;
        for (int i=n-2; i>=0; i--) {
            int min = 10001;
            for (int j=1; j<=nums[i] && j<n; j++) {
                if ((i+j) < n && dp[i+j]!=-1 && min>dp[i+j]) {
                    min = dp[i+j];
                    dp[i] = min+1;
                }
            }
        }
        return dp[0];
    }
}
