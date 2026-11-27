package com.leetcode.arrays_hashing_greedy;

class Solution2211 {
    public int countCollisions(String directions) {
        char[] s = directions.toCharArray();
        int n = s.length;
        int l = 0, r = n - 1;
        while (l < n && s[l] == 'L') {
            ++l;
        }
        while (r >= 0 && s[r] == 'R') {
            --r;
        }
        int ans = r - l + 1;
        for (int i = l; i <= r; ++i) {
            ans -= s[i] == 'S' ? 1 : 0;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2211 _tcSol = new Solution2211();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "directions = \"RLRSLL\"");
        try {
            String directions = "RLRSLL";
            System.out.println("  Output  : " + _tcShow(_tcSol.countCollisions(directions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "directions = \"LLRR\"");
        try {
            String directions = "LLRR";
            System.out.println("  Output  : " + _tcShow(_tcSol.countCollisions(directions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
