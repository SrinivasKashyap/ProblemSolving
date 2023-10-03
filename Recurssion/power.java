public class power {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        else if (n < 0) {
            x = 1/x;
            n = -1 * n;
        }
        return util(x, n);
    }
    public double util(double x, int n) {
        if (n == 0) return 1;
        double res = util(x, n/2);
        if (n%2 == 0) return res * res;
        return res * res * x;
    }
        public static void main(String[] args) {
        int a = 1/2;
        System.out.println(a);
    }
}
