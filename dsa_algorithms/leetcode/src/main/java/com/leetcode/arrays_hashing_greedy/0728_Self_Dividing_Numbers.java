package com.leetcode.arrays_hashing_greedy;

class Solution0728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int x = left; x <= right; ++x) {
            if (check(x)) {
                ans.add(x);
            }
        }
        return ans;
    }

    private boolean check(int x) {
        for (int y = x; y > 0; y /= 10) {
            if (y % 10 == 0 || x % (y % 10) != 0) {
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
        Solution0728 _tcSol = new Solution0728();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "left = 1, right = 22");
        try {
            int left = 1;
            int right = 22;
            System.out.println("  Output  : " + _tcShow(_tcSol.selfDividingNumbers(left, right)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,3,4,5,6,7,8,9,11,12,15,22]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "left = 47, right = 85");
        try {
            int left = 47;
            int right = 85;
            System.out.println("  Output  : " + _tcShow(_tcSol.selfDividingNumbers(left, right)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[48,55,66,77]");
        System.out.println();
    }
}
