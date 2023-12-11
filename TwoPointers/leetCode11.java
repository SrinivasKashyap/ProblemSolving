package TwoPointers;

public class leetCode11 {
    public int maxArea(int[] height) {
        int n = height.length;
        int i=0;
        int j=n-1;
        int area = 0;
        while(i<j) {
            int h = Math.min(height[i], height[j]);
            int l = j-i;
            if ((h*l) > area) {
                area = h*l;
            }
            while (i<j && height[i]<=h) {
                i++;
            } 
            while (i<j && height[j]<=h) {
                j--;
            }

        }
        // for (;i<=j;i++) {
        //     area -= height[i];
        // }
        return area;
    }
}
