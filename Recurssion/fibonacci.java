import java.util.HashMap;
import java.util.Map;

public class fibonacci {
        public int fib(int n) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 0);
        map.put(1, 1);
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else {
            return util(n, map);
        }
    }
    public int util (int n, Map<Integer, Integer> map) {
        Integer x = map.get(n);
        if (null == x) {
            x = util(n-1, map) + util(n-2, map);     
            map.put(n, x);
        }
        return x;
    }
}
