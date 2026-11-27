package com.leetcode.strings;

class Solution2434 {
    public String robotWithString(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            ++cnt[c - 'a'];
        }
        StringBuilder ans = new StringBuilder();
        Deque<Character> stk = new ArrayDeque<>();
        char mi = 'a';
        for (char c : s.toCharArray()) {
            --cnt[c - 'a'];
            while (mi < 'z' && cnt[mi - 'a'] == 0) {
                ++mi;
            }
            stk.push(c);
            while (!stk.isEmpty() && stk.peek() <= mi) {
                ans.append(stk.pop());
            }
        }
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2434 _tcSol = new Solution2434();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"zza\"");
        try {
            String s = "zza";
            System.out.println("  Output  : " + _tcShow(_tcSol.robotWithString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"azz\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"bac\"");
        try {
            String s = "bac";
            System.out.println("  Output  : " + _tcShow(_tcSol.robotWithString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"abc\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"bdda\"");
        try {
            String s = "bdda";
            System.out.println("  Output  : " + _tcShow(_tcSol.robotWithString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"addb\"");
        System.out.println();
    }
}