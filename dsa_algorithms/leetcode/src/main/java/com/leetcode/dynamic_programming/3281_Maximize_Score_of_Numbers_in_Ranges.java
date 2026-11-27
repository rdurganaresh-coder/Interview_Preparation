package com.leetcode.dynamic_programming;

class Solution3281 {
    private int[] start;
    private int d;

    public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);
        this.start = start;
        this.d = d;
        int n = start.length;
        int l = 0, r = start[n - 1] + d - start[0];
        while (l < r) {
            int mid = (l + r + 1) >>> 1;
            if (check(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private boolean check(int mi) {
        long last = Long.MIN_VALUE;
        for (int st : start) {
            if (last + mi > st + d) {
                return false;
            }
            last = Math.max(st, last + mi);
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3281 _tcSol = new Solution3281();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "start = [6,0,3], d = 2");
        try {
            int[] start = new int[]{6, 0, 3};
            int d = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxPossibleScore(start, d)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "start = [2,6,13,13], d = 5");
        try {
            int[] start = new int[]{2, 6, 13, 13};
            int d = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxPossibleScore(start, d)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}
