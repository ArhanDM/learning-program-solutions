public class ForecastTest {
    public static void main(String[] args) {
        double principal = 10000; // ₹10,000
        double rate = 0.05;       // 5% annual growth
        int years = 5;

        double resultRecursive = FinancialForecaster.futureValueRecursive(principal, rate, years);
        System.out.println("Future Value (Recursive): ₹" + resultRecursive);

        Double[] memo = new Double[years + 1];
        double resultMemo = FinancialForecaster.futureValueMemo(principal, rate, years, memo);
        System.out.println("Future Value (Memoized): ₹" + resultMemo);

        double resultIterative = FinancialForecaster.futureValueIterative(principal, rate, years);
        System.out.println("Future Value (Iterative): ₹" + resultIterative);
    }
}
