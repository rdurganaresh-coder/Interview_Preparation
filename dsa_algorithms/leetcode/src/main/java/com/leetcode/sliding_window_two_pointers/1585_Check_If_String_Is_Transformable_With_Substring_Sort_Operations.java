package com.leetcode.sliding_window_two_pointers;

class Solution1585 {
    public boolean isTransformable(String s, String t) {
        Deque<Integer>[] pos = new Deque[10];
        Arrays.setAll(pos, k -> new ArrayDeque<>());
        for (int i = 0; i < s.length(); ++i) {
            pos[s.charAt(i) - '0'].offer(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            int x = t.charAt(i) - '0';
            if (pos[x].isEmpty()) {
                return false;
            }
            for (int j = 0; j < x; ++j) {
                if (!pos[j].isEmpty() && pos[j].peek() < pos[x].peek()) {
                    return false;
                }
            }
            pos[x].poll();
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1585 _tcSol = new Solution1585();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"84532\", t = \"34852\"");
        try {
            String s = "84532";
            String t = "34852";
            System.out.println("  Output  : " + _tcShow(_tcSol.isTransformable(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"34521\", t = \"23415\"");
        try {
            String s = "34521";
            String t = "23415";
            System.out.println("  Output  : " + _tcShow(_tcSol.isTransformable(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"12345\", t = \"12435\"");
        try {
            String s = "12345";
            String t = "12435";
            System.out.println("  Output  : " + _tcShow(_tcSol.isTransformable(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}