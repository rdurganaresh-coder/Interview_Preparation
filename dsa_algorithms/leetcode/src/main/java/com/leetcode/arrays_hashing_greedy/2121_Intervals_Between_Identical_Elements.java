package com.leetcode.arrays_hashing_greedy;

class Solution2121 {
    public long[] getDistances(int[] arr) {
        Map<Integer, List<Integer>> d = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            d.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        long[] ans = new long[n];
        for (List<Integer> v : d.values()) {
            int m = v.size();
            long val = 0;
            for (int e : v) {
                val += e;
            }
            val -= 1L * m * v.get(0);
            for (int i = 0; i < v.size(); ++i) {
                int delta = i >= 1 ? v.get(i) - v.get(i - 1) : 0;
                val += 1L * i * delta - 1L * (m - i) * delta;
                ans[v.get(i)] = val;
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2121 _tcSol = new Solution2121();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [2,1,3,1,2,3,3]");
        try {
            int[] arr = new int[]{2, 1, 3, 1, 2, 3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.getDistances(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,2,7,2,4,4,5]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [10,5,10,10]");
        try {
            int[] arr = new int[]{10, 5, 10, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.getDistances(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5,0,3,4]");
        System.out.println();
    }
}