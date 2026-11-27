package com.leetcode.trees_tries;

class Solution0823 {
    public int numFactoredBinaryTrees(int[] arr) {
        final int mod = (int) 1e9 + 7;
        Arrays.sort(arr);
        int n = arr.length;
        long[] f = new long[n];
        Arrays.fill(f, 1);
        Map<Integer, Integer> idx = new HashMap<>(n);
        for (int i = 0; i < n; ++i) {
            idx.put(arr[i], i);
        }
        for (int i = 0; i < n; ++i) {
            int a = arr[i];
            for (int j = 0; j < i; ++j) {
                int b = arr[j];
                if (a % b == 0) {
                    int c = a / b;
                    if (idx.containsKey(c)) {
                        int k = idx.get(c);
                        f[i] = (f[i] + f[j] * f[k]) % mod;
                    }
                }
            }
        }
        long ans = 0;
        for (long v : f) {
            ans = (ans + v) % mod;
        }
        return (int) ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0823 _tcSol = new Solution0823();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [2,4]");
        try {
            int[] arr = new int[]{2, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.numFactoredBinaryTrees(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [2,4,5,10]");
        try {
            int[] arr = new int[]{2, 4, 5, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.numFactoredBinaryTrees(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();
    }
}