package com.leetcode.arrays_hashing_greedy;

class Solution2861 {
    int n;
    int budget;
    List<List<Integer>> composition;
    List<Integer> stock;
    List<Integer> cost;

    boolean isValid(long target) {
        for (List<Integer> currMachine : composition) {
            long remain = budget;
            for (int j = 0; j < n && remain >= 0; j++) {
                long need = Math.max(0, currMachine.get(j) * target - stock.get(j));
                remain -= need * cost.get(j);
            }
            if (remain >= 0) {
                return true;
            }
        }
        return false;
    }

    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition,
        List<Integer> stock, List<Integer> cost) {
        this.n = n;
        this.budget = budget;
        this.composition = composition;
        this.stock = stock;
        this.cost = cost;
        int l = -1;
        int r = budget / cost.get(0) + stock.get(0);
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (isValid(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
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
        Solution2861 _tcSol = new Solution2861();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, k = 2, budget = 15, composition = [[1,1,1],[1,1,10]], stock = [0,0,0], cost = [1,2,3]");
        try {
            int n = 3;
            int k = 2;
            int budget = 15;
            List<List<Integer>> composition = _tcL(_tcL(1, 1, 1), _tcL(1, 1, 10));
            List<Integer> stock = _tcL(0, 0, 0);
            List<Integer> cost = _tcL(1, 2, 3);
            System.out.println("  Output  : " + _tcShow(_tcSol.maxNumberOfAlloys(n, k, budget, composition, stock, cost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, k = 2, budget = 15, composition = [[1,1,1],[1,1,10]], stock = [0,0,100], cost = [1,2,3]");
        try {
            int n = 3;
            int k = 2;
            int budget = 15;
            List<List<Integer>> composition = _tcL(_tcL(1, 1, 1), _tcL(1, 1, 10));
            List<Integer> stock = _tcL(0, 0, 100);
            List<Integer> cost = _tcL(1, 2, 3);
            System.out.println("  Output  : " + _tcShow(_tcSol.maxNumberOfAlloys(n, k, budget, composition, stock, cost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 2, k = 3, budget = 10, composition = [[2,1],[1,2],[1,1]], stock = [1,1], cost = [5,5]");
        try {
            int n = 2;
            int k = 3;
            int budget = 10;
            List<List<Integer>> composition = _tcL(_tcL(2, 1), _tcL(1, 2), _tcL(1, 1));
            List<Integer> stock = _tcL(1, 1);
            List<Integer> cost = _tcL(5, 5);
            System.out.println("  Output  : " + _tcShow(_tcSol.maxNumberOfAlloys(n, k, budget, composition, stock, cost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}