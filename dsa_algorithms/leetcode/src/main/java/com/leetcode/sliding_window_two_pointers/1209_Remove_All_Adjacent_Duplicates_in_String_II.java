package com.leetcode.sliding_window_two_pointers;

class Solution1209 {
    public String removeDuplicates(String s, int k) {
        Deque<int[]> stk = new ArrayDeque<>();
        for (int i = 0; i < s.length(); ++i) {
            int j = s.charAt(i) - 'a';
            if (!stk.isEmpty() && stk.peek()[0] == j) {
                stk.peek()[1] = (stk.peek()[1] + 1) % k;
                if (stk.peek()[1] == 0) {
                    stk.pop();
                }
            } else {
                stk.push(new int[] {j, 1});
            }
        }
        StringBuilder ans = new StringBuilder();
        for (var e : stk) {
            char c = (char) (e[0] + 'a');
            for (int i = 0; i < e[1]; ++i) {
                ans.append(c);
            }
        }
        ans.reverse();
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1209 _tcSol = new Solution1209();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abcd\", k = 2");
        try {
            String s = "abcd";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.removeDuplicates(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"abcd\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"deeedbbcccbdaa\", k = 3");
        try {
            String s = "deeedbbcccbdaa";
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.removeDuplicates(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"aa\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"pbbcggttciiippooaais\", k = 2");
        try {
            String s = "pbbcggttciiippooaais";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.removeDuplicates(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"ps\"");
        System.out.println();
    }
}