package com.leetcode.arrays_hashing_greedy;

class Solution0825 {
    public int numFriendRequests(int[] ages) {
        final int m = 121;
        int[] cnt = new int[m];
        for (int x : ages) {
            ++cnt[x];
        }
        int ans = 0;
        for (int ax = 1; ax < m; ++ax) {
            for (int ay = 1; ay < m; ++ay) {
                if (!(ay <= 0.5 * ax + 7 || ay > ax || (ay > 100 && ax < 100))) {
                    ans += cnt[ax] * (cnt[ay] - (ax == ay ? 1 : 0));
                }
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
        Solution0825 _tcSol = new Solution0825();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "ages = [16,16]");
        try {
            int[] ages = new int[]{16, 16};
            System.out.println("  Output  : " + _tcShow(_tcSol.numFriendRequests(ages)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "ages = [16,17,18]");
        try {
            int[] ages = new int[]{16, 17, 18};
            System.out.println("  Output  : " + _tcShow(_tcSol.numFriendRequests(ages)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "ages = [20,30,100,110,120]");
        try {
            int[] ages = new int[]{20, 30, 100, 110, 120};
            System.out.println("  Output  : " + _tcShow(_tcSol.numFriendRequests(ages)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
