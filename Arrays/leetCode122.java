public class leetCode122 {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 0;
        boolean b = false;
        int n = prices.length;
        int profit = 0;
        if (n==1) return profit;
        for (int i=0; i<n; i++) {
            if (!b) {
                if (i==0 && (prices[i] <= prices[i+1])) {
                    b = true;
                    buy = prices[i];
                } else if ((i<n-1) && (prices[i] <= prices[i+1]) 
                && (prices[i] <= prices[i-1])) {
                    b = true;
                    buy = prices[i];
                }
            } else {
                if ((i>0) && (i< n-1) && (prices[i] >= prices[i-1]) 
                && (prices[i] >= prices[i+1])) {
                    b= false;
                    sell = prices[i];
                    profit += (sell - buy);
                } else if ((i== n-1) && (prices[i] >= prices[i-1])) {
                    b= false;
                    sell = prices[i];
                    profit += (sell - buy);
                }
            }
        }
        return profit;
    }
}
