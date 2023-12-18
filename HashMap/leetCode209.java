package HashMap;

import java.util.HashMap;
import java.util.Map;

public class leetCode209 {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i=0; i<nums.length; i++) {
            Integer j = map.get(nums[i]);
            
            if (null != j && (i-j) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
