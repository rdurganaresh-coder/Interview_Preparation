package com.leetcode.stacks_queues;

class Solution0394 {
    public String decodeString(String s) {
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<String> s2 = new ArrayDeque<>();
        int num = 0;
        String res = "";
        for (char c : s.toCharArray()) {
            if ('0' <= c && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                s1.push(num);
                s2.push(res);
                num = 0;
                res = "";
            } else if (c == ']') {
                StringBuilder t = new StringBuilder();
                for (int i = 0, n = s1.pop(); i < n; ++i) {
                    t.append(res);
                }
                res = s2.pop() + t.toString();
            } else {
                res += String.valueOf(c);
            }
        }
        return res;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0394 _tcSol = new Solution0394();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"3[a]2[bc]\"");
        try {
            String s = "3[a]2[bc]";
            System.out.println("  Output  : " + _tcShow(_tcSol.decodeString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"aaabcbc\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"3[a2[c]]\"");
        try {
            String s = "3[a2[c]]";
            System.out.println("  Output  : " + _tcShow(_tcSol.decodeString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"accaccacc\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"2[abc]3[cd]ef\"");
        try {
            String s = "2[abc]3[cd]ef";
            System.out.println("  Output  : " + _tcShow(_tcSol.decodeString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"abcabccdcdcdef\"");
        System.out.println();
    }
}