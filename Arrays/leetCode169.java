/*
 * Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 */
import java.util.HashMap;
import java.util.Map;

public class leetCode169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = nums.length;
        for (int i=0; i<n; i++) {
            Integer x = map.get(nums[i]);
            if (null == x) map.put(nums[i], 1);
            else {
                map.put(nums[i], ++x);
                if (x > n/2) return nums[i];
            }
        }
        return nums[n-1];
    }
}

/*
 * Best solution
 * class Solution {
    public int majorityElement(int[] nums) {
        return util(nums, 0, nums[0]);
    }
    public int util(int[] nums, int st, int ref) {
        int c = 0;
        for (int i=st; i<nums.length; i++) {
            if (nums[i] == ref) c++;
            else c--;
            if (c==-1) return util(nums, i, nums[i]);
        }
        return ref;
    }
}
 */