package Graph;

public class Pair<T1, T2> {
    Integer i = 0;
    Integer j = 0;
    String a;
    Double b = 0.0;
    Integer c;
    Integer d;

    Pair(int a, int b) {
        this.i = a;
        this.j = b;
    }

    Pair(String a, Double b) {
        this.a = a;
        this.b = b;
    }

    Pair(String a, Integer b) {
        this.a = a;
        this.c = b;
    }

    Pair(Integer a, Integer b) {
        this.d = a;
        this.c = b;
    }

    public String getKey() {
        return this.a;
    }

    public Double getValue() {
        return this.b;
    }

    public Integer getKey() {
        return this.c;
    }

    public Integer getValue() {
        return this.d;
    }
}
