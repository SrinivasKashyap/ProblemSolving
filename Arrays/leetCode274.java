public class leetCode274 {
    public int hIndex(int[] citations) {
        // My Solution
        // int n = citations.length;
        // Arrays.sort(citations);
        // for (int i=n-1; i>=0; i--) {
        //     int h = i+1;
        //     boolean flag = true;
        //     int count = 0;
        //     for (int j=n-1; j>=0; j--) {
        //         if (citations[j] < h) {
        //             break;
        //         } else {
        //             count++;
        //         }
        //     }
        //     if (count >= h) return h;
        // }
        // return 0;

        //Optimal Solution
        int n = citations.length;
        int[] paperCount = new int[n+1];
        for (int i=0; i<n; i++) {
            int c = citations[i];
            if (c>=n) paperCount[n]++;
            else paperCount[c]++; 
        }
        int h=0;
        for (int i=n; i>=0; i--) {
            h+=paperCount[i];
            if (h>=i) return i;
        }
        return 0;
    }
}
