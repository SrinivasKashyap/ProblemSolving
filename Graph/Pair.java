package Graph;

public class Pair<T1, T2> {
    Integer i = 0;
    Integer j = 0;
    String a;
    Double b = 0.0;

    Pair(int a, int b) {
        this.i = a;
        this.j = b;
    }

    Pair(String a, Double b) {
        this.a = a;
        this.b = b;
    }

    public String getKey() {
        return this.a;
    }

    public Double getValue() {
        return this.b;
    }
}
