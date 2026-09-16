class Solution {

    static final long MOD = 1000000007L;

    public int numberOfSets(int n, int k) {

        int N = n + k - 1;
        int R = 2 * k;

        long[] fact = new long[N + 1];

        fact[0] = 1;

        for (int i = 1; i <= N; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        long numerator = fact[N];

        long denominator =
                (fact[R] * fact[N - R]) % MOD;

        long answer =
                numerator * power(denominator, MOD - 2) % MOD;

        return (int) answer;
    }


    private long power(long base, long exp) {

        long result = 1;

        while (exp > 0) {

            if (exp % 2 == 1) {
                result = (result * base) % MOD;
            }

            base = (base * base) % MOD;

            exp = exp / 2;
        }

        return result;
    }
}