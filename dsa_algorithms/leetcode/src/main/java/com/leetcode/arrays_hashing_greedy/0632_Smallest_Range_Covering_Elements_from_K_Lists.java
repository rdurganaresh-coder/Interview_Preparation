package com.leetcode.arrays_hashing_greedy;

class Solution0632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        int n = 0;
        for (var v : nums) {
            n += v.size();
        }
        int[][] t = new int[n][2];
        int k = nums.size();
        for (int i = 0, j = 0; i < k; ++i) {
            for (int x : nums.get(i)) {
                t[j++] = new int[] {x, i};
            }
        }
        Arrays.sort(t, (a, b) -> a[0] - b[0]);
        int j = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        int[] ans = new int[] {-1000000, 1000000};
        for (int[] e : t) {
            int b = e[0];
            int v = e[1];
            cnt.merge(v, 1, Integer::sum);
            while (cnt.size() == k) {
                int a = t[j][0];
                int w = t[j][1];
                int x = b - a - (ans[1] - ans[0]);
                if (x < 0 || (x == 0 && a < ans[0])) {
                    ans[0] = a;
                    ans[1] = b;
                }
                if (cnt.merge(w, -1, Integer::sum) == 0) {
                    cnt.remove(w);
                }
                ++j;
            }
        }
        return ans;
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
        Solution0632 _tcSol = new Solution0632();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]");
        try {
            List<List<Integer>> nums = _tcL(_tcL(4, 10, 15, 24, 26), _tcL(0, 9, 12, 20), _tcL(5, 18, 22, 30));
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestRange(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[20,24]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [[1,2,3],[1,2,3],[1,2,3]]");
        try {
            List<List<Integer>> nums = _tcL(_tcL(1, 2, 3), _tcL(1, 2, 3), _tcL(1, 2, 3));
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestRange(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,1]");
        System.out.println();
    }
}
