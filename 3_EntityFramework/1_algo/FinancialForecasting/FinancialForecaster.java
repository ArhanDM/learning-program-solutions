public class FinancialForecaster {

    // Recursive method to calculate future value
    public static double futureValueRecursive(double principal, double rate, int years) {
        if (years == 0) {
            return principal;  // base case
        }
        return futureValueRecursive(principal, rate, years - 1) * (1 + rate);
    }

    // Optimized version using memoization (optional)
    public static double futureValueMemo(double principal, double rate, int years, Double[] memo) {
        if (years == 0) return principal;
        if (memo[years] != null) return memo[years];

        memo[years] = futureValueMemo(principal, rate, years - 1, memo) * (1 + rate);
        return memo[years];
    }

    // Iterative version for comparison (alternative)
    public static double futureValueIterative(double principal, double rate, int years) {
        double result = principal;
        for (int i = 0; i < years; i++) {
            result *= (1 + rate);
        }
        return result;
    }
}
