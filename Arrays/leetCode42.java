public class leetCode42 {
    public int trap(int[] height) {
        int n = height.length;
        int right[] = new int[n];
        int left[] = new int[n];
        int max = 0;
        left[0] = max;
        if (height[0] > max) max = height[0];
        for (int i=1; i<n; i++) {
            left[i] = max;
            if (height[i] > max) max = height[i];
        }
        max = 0;
        right[n-1] = max;
        if (height[n-1] > max) max = height[n-1];
        for (int i=n-2; i>=0; i--) {
            right[i] = max;
            if (height[i] > max) max = height[i];
        }
        int water = 0;
        for (int i=0; i<n; i++) {
            int temp = Math.min(right[i], left[i]) - height[i];
            if (temp >= 0) water+=temp;
        }
        return water;
    }
}
