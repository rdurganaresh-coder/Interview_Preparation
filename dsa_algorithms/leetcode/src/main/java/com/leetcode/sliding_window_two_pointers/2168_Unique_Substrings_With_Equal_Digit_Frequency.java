package com.leetcode.sliding_window_two_pointers;

class Solution2168 {
    public int equalDigitFrequency(String s) {
        int n = s.length();
        int[][] presum = new int[n + 1][10];
        for (int i = 0; i < n; ++i) {
            ++presum[i + 1][s.charAt(i) - '0'];
            for (int j = 0; j < 10; ++j) {
                presum[i + 1][j] += presum[i][j];
            }
        }
        Set<String> vis = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                if (check(i, j, presum)) {
                    vis.add(s.substring(i, j + 1));
                }
            }
        }
        return vis.size();
    }

    private boolean check(int i, int j, int[][] presum) {
        Set<Integer> v = new HashSet<>();
        for (int k = 0; k < 10; ++k) {
            int cnt = presum[j + 1][k] - presum[i][k];
            if (cnt > 0) {
                v.add(cnt);
            }
            if (v.size() > 1) {
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
        Solution2168 _tcSol = new Solution2168();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"1212\"");
        try {
            String s = "1212";
            System.out.println("  Output  : " + _tcShow(_tcSol.equalDigitFrequency(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"12321\"");
        try {
            String s = "12321";
            System.out.println("  Output  : " + _tcShow(_tcSol.equalDigitFrequency(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();
    }
}