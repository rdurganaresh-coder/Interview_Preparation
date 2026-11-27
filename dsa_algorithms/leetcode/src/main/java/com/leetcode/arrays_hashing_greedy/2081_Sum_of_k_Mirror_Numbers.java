package com.leetcode.arrays_hashing_greedy;

class Solution2081 {
    public long kMirror(int k, int n) {
        long ans = 0;
        for (int l = 1;; l++) {
            int x = (int) Math.pow(10, (l - 1) / 2);
            int y = (int) Math.pow(10, (l + 1) / 2);
            for (int i = x; i < y; i++) {
                long v = i;
                int j = (l % 2 == 0) ? i : i / 10;
                while (j > 0) {
                    v = v * 10 + j % 10;
                    j /= 10;
                }
                if (check(v, k)) {
                    ans += v;
                    n--;
                    if (n == 0) {
                        return ans;
                    }
                }
            }
        }
    }

    private boolean check(long x, int k) {
        List<Integer> s = new ArrayList<>();
        while (x > 0) {
            s.add((int) (x % k));
            x /= k;
        }
        for (int i = 0, j = s.size() - 1; i < j; ++i, --j) {
            if (!s.get(i).equals(s.get(j))) {
                return false;
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2081 _tcSol = new Solution2081();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "k = 2, n = 5");
        try {
            int k = 2;
            int n = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.kMirror(k, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "25");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "k = 3, n = 7");
        try {
            int k = 3;
            int n = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.kMirror(k, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "499");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "k = 7, n = 17");
        try {
            int k = 7;
            int n = 17;
            System.out.println("  Output  : " + _tcShow(_tcSol.kMirror(k, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "20379000");
        System.out.println();
    }
}
