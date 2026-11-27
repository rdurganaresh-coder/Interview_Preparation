package com.leetcode.arrays_hashing_greedy;

class Solution2830 {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        offers.sort((a, b) -> a.get(1) - b.get(1));
        n = offers.size();
        int[] f = new int[n + 1];
        int[] g = new int[n];
        for (int i = 0; i < n; ++i) {
            g[i] = offers.get(i).get(1);
        }
        for (int i = 1; i <= n; ++i) {
            var o = offers.get(i - 1);
            int j = search(g, o.get(0));
            f[i] = Math.max(f[i - 1], f[j] + o.get(2));
        }
        return f[n];
    }

    private int search(int[] nums, int x) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= x) {
                r = mid;
            } else {
                l = mid + 1;
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
        Solution2830 _tcSol = new Solution2830();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 5, offers = [[0,0,1],[0,2,2],[1,3,2]]");
        try {
            int n = 5;
            List<List<Integer>> offers = _tcL(_tcL(0, 0, 1), _tcL(0, 2, 2), _tcL(1, 3, 2));
            System.out.println("  Output  : " + _tcShow(_tcSol.maximizeTheProfit(n, offers)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5, offers = [[0,0,1],[0,2,10],[1,3,2]]");
        try {
            int n = 5;
            List<List<Integer>> offers = _tcL(_tcL(0, 0, 1), _tcL(0, 2, 10), _tcL(1, 3, 2));
            System.out.println("  Output  : " + _tcShow(_tcSol.maximizeTheProfit(n, offers)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();
    }
}