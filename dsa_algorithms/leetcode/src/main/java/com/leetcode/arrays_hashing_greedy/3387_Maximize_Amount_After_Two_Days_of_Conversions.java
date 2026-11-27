package com.leetcode.arrays_hashing_greedy;

class Solution3387 {
    public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1,
        List<List<String>> pairs2, double[] rates2) {
        Map<String, Double> d1 = build(pairs1, rates1, initialCurrency);
        Map<String, Double> d2 = build(pairs2, rates2, initialCurrency);
        double ans = 0;
        for (Map.Entry<String, Double> entry : d2.entrySet()) {
            String currency = entry.getKey();
            double rate = entry.getValue();
            if (d1.containsKey(currency)) {
                ans = Math.max(ans, d1.get(currency) / rate);
            }
        }
        return ans;
    }

    private Map<String, Double> build(List<List<String>> pairs, double[] rates, String init) {
        Map<String, List<Pair<String, Double>>> g = new HashMap<>();
        Map<String, Double> d = new HashMap<>();
        for (int i = 0; i < pairs.size(); ++i) {
            String a = pairs.get(i).get(0);
            String b = pairs.get(i).get(1);
            double r = rates[i];
            g.computeIfAbsent(a, k -> new ArrayList<>()).add(new Pair<>(b, r));
            g.computeIfAbsent(b, k -> new ArrayList<>()).add(new Pair<>(a, 1 / r));
        }
        dfs(g, d, init, 1.0);
        return d;
    }

    private void dfs(
        Map<String, List<Pair<String, Double>>> g, Map<String, Double> d, String a, double v) {
        if (d.containsKey(a)) {
            return;
        }

        d.put(a, v);
        for (Pair<String, Double> pair : g.getOrDefault(a, List.of())) {
            String b = pair.getKey();
            double r = pair.getValue();
            if (!d.containsKey(b)) {
                dfs(g, d, b, v * r);
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution3387 _tcSol = new Solution3387();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "initialCurrency = \"EUR\", pairs1 = [[\"EUR\",\"USD\"],[\"USD\",\"JPY\"]], rates1 = [2.0,3.0], pairs2 = [[\"JPY\",\"USD\"],[\"USD\",\"CHF\"],[\"CHF\",\"EUR\"]], rates2 = [4.0,5.0,6.0]");
        try {
            String initialCurrency = "EUR";
            List<List<String>> pairs1 = _tcL(_tcL("EUR", "USD"), _tcL("USD", "JPY"));
            double[] rates1 = new double[]{2.0, 3.0};
            List<List<String>> pairs2 = _tcL(_tcL("JPY", "USD"), _tcL("USD", "CHF"), _tcL("CHF", "EUR"));
            double[] rates2 = new double[]{4.0, 5.0, 6.0};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxAmount(initialCurrency, pairs1, rates1, pairs2, rates2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "720.00000");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "initialCurrency = \"NGN\", pairs1 = [[\"NGN\",\"EUR\"]], rates1 = [9.0], pairs2 = [[\"NGN\",\"EUR\"]], rates2 = [6.0]");
        try {
            String initialCurrency = "NGN";
            List<List<String>> pairs1 = _tcL(_tcL("NGN", "EUR"));
            double[] rates1 = new double[]{9.0};
            List<List<String>> pairs2 = _tcL(_tcL("NGN", "EUR"));
            double[] rates2 = new double[]{6.0};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxAmount(initialCurrency, pairs1, rates1, pairs2, rates2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1.50000");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "initialCurrency = \"USD\", pairs1 = [[\"USD\",\"EUR\"]], rates1 = [1.0], pairs2 = [[\"EUR\",\"JPY\"]], rates2 = [10.0]");
        try {
            String initialCurrency = "USD";
            List<List<String>> pairs1 = _tcL(_tcL("USD", "EUR"));
            double[] rates1 = new double[]{1.0};
            List<List<String>> pairs2 = _tcL(_tcL("EUR", "JPY"));
            double[] rates2 = new double[]{10.0};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxAmount(initialCurrency, pairs1, rates1, pairs2, rates2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1.00000");
        System.out.println();
    }
}
