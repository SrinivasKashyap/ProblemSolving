public class leetCode135 {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int[] candies = new int[n];
        for (int i=0; i<n; i++) {
            candies[i] = 1;
        }
        for (int i=0; i<n; i++) {
            util(ratings, candies, i, n);
        }
        for (int i=n-1; i>=0; i--) {
            util(ratings, candies, i, n);
        }
        int result = 0;
        for (int i=0; i<n; i++) {
            result+=candies[i];
        }
        return result;
    }
    public void util(int[] ratings, int[] candies, int i, int n) {
                    if (i==0) {
                if (n>1 && ratings[i] > ratings[i+1]) {
                    candies[i] = candies[i+1] + 1;
                }
            } else if (i==n-1) {
                if (n>1 && ratings[i] > ratings[i-1]) {
                    candies[i] = candies[i-1] + 1;
                }
            } else {
                if (ratings[i] > ratings[i-1] && ratings[i] > ratings[i+1]) {
                    candies[i] = Math.max(candies[i-1], candies[i+1]) + 1;
                } else if (ratings[i] > ratings[i+1]) {
                    candies[i] = candies[i+1] + 1;
                } else if (ratings[i] > ratings[i-1]) {
                    candies[i] = candies[i-1] + 1;
                }
            }
    }
}
