package com.leetcode.strings;

class Solution0481 {
    public int magicalString(int n) {
        List<Integer> s = new ArrayList<>(List.of(1, 2, 2));
        for (int i = 2; s.size() < n; ++i) {
            int pre = s.get(s.size() - 1);
            int cur = 3 - pre;
            for (int j = 0; j < s.get(i); ++j) {
                s.add(cur);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (s.get(i) == 1) {
                ++ans;
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
        Solution0481 _tcSol = new Solution0481();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 6");
        try {
            int n = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.magicalString(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 1");
        try {
            int n = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.magicalString(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}