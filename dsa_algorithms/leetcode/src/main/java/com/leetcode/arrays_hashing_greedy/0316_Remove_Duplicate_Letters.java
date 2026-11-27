package com.leetcode.arrays_hashing_greedy;

class Solution0316 {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        int[] last = new int[26];
        for (int i = 0; i < n; ++i) {
            last[s.charAt(i) - 'a'] = i;
        }
        Deque<Character> stk = new ArrayDeque<>();
        int mask = 0;
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (((mask >> (c - 'a')) & 1) == 1) {
                continue;
            }
            while (!stk.isEmpty() && stk.peek() > c && last[stk.peek() - 'a'] > i) {
                mask ^= 1 << (stk.pop() - 'a');
            }
            stk.push(c);
            mask |= 1 << (c - 'a');
        }
        StringBuilder ans = new StringBuilder();
        for (char c : stk) {
            ans.append(c);
        }
        return ans.reverse().toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0316 _tcSol = new Solution0316();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"bcabc\"");
        try {
            String s = "bcabc";
            System.out.println("  Output  : " + _tcShow(_tcSol.removeDuplicateLetters(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"abc\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"cbacdcbc\"");
        try {
            String s = "cbacdcbc";
            System.out.println("  Output  : " + _tcShow(_tcSol.removeDuplicateLetters(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"acdb\"");
        System.out.println();
    }
}