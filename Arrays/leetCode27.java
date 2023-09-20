/*Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
Return k.*/

class leetCode27 {
    public int removeElement(int[] nums, int val) {
        int cnt = 0;
        for (int i=0; i< nums.length; i++) {
            if (nums[i] != val) cnt++;
        }
        for (int i=0; i < nums.length; i++) {
            if (nums[i] == val) swap(i, nums, cnt, val);
        }
        return cnt;
    }
    public void swap(int i, int[] nums, int cnt, int val) {
        if (i < cnt) {
            for (int j=i+1; j< nums.length; j++) {
                if (nums[j] != val) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }
}