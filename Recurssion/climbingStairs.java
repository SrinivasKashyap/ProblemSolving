import java.util.HashMap;
import java.util.Map;

public class climbingStairs {
        public int climbStairs(int n) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 2);
        if (n > 2) return util(n, map);
        return map.get(n);
    }
    
    public int util(int n, Map<Integer, Integer> map) {
        Integer x = map.get(n);
        if (null == x) {
            x = util(n-1, map) + util(n-2, map);
            map.put(n, x);
        } 
        return x;
    }
}
