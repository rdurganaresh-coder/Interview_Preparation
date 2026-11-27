package com.leetcode.arrays_hashing_greedy;

class Solution1124 {
    public int longestWPI(int[] hours) {
        int ans = 0, s = 0;
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < hours.length; ++i) {
            s += hours[i] > 8 ? 1 : -1;
            if (s > 0) {
                ans = i + 1;
            } else if (pos.containsKey(s - 1)) {
                ans = Math.max(ans, i - pos.get(s - 1));
            }
            pos.putIfAbsent(s, i);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1124 _tcSol = new Solution1124();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "hours = [9,9,6,0,6,6,9]");
        try {
            int[] hours = new int[]{9, 9, 6, 0, 6, 6, 9};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestWPI(hours)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "hours = [6,6,6]");
        try {
            int[] hours = new int[]{6, 6, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestWPI(hours)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}