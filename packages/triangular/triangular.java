package packages.triangular;

public class triangular {
    private int n;

    public triangular(int n) {
        this.n = n * (n + 1) / 2;
    }

    public int value() {
        return this.n;
    }
}
