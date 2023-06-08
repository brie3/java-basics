package packages.factorial;

public class factorial {
    private long n;

    public factorial(int n) {
        this.n = 1;
        for (int factor = 2; factor <= n; factor++) {
            this.n *= factor;
        }
    }

    public long value() {
        return this.n;
    }
}
