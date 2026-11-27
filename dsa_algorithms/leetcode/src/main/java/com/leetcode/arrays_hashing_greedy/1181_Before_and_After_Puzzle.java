package com.leetcode.arrays_hashing_greedy;

class Solution1181 {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        int n = phrases.length;
        var ps = new String[n][];
        for (int i = 0; i < n; ++i) {
            var ws = phrases[i].split(" ");
            ps[i] = new String[] {ws[0], ws[ws.length - 1]};
        }
        Set<String> s = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i != j && ps[i][1].equals(ps[j][0])) {
                    s.add(phrases[i] + phrases[j].substring(ps[j][0].length()));
                }
            }
        }
        var ans = new ArrayList<>(s);
        Collections.sort(ans);
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1181 _tcSol = new Solution1181();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "phrases = [\"writing code\",\"code rocks\"]");
        try {
            String[] phrases = new String[]{"writing code", "code rocks"};
            System.out.println("  Output  : " + _tcShow(_tcSol.beforeAndAfterPuzzles(phrases)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"writing code rocks\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "phrases = [\"mission statement\",\"a quick bite to eat\",\"a chip off the old block\",\"chocolate bar\",\"mission impossible\",\"a man on a mission\",\"block party\",\"eat my words\",\"bar of soap\"]");
        try {
            String[] phrases = new String[]{"mission statement", "a quick bite to eat", "a chip off the old block", "chocolate bar", "mission impossible", "a man on a mission", "block party", "eat my words", "bar of soap"};
            System.out.println("  Output  : " + _tcShow(_tcSol.beforeAndAfterPuzzles(phrases)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"a chip off the old block party\",\"a man on a mission impossible\",\"a man on a mission statement\",\"a quick bite to eat my words\",\"chocolate bar of soap\"]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "phrases = [\"a\",\"b\",\"a\"]");
        try {
            String[] phrases = new String[]{"a", "b", "a"};
            System.out.println("  Output  : " + _tcShow(_tcSol.beforeAndAfterPuzzles(phrases)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"a\"]");
        System.out.println();

        System.out.println("Test 4");
        System.out.println("  Input   : " + "phrases = [\"ab ba\",\"ba ab\",\"ab ba\"]");
        try {
            String[] phrases = new String[]{"ab ba", "ba ab", "ab ba"};
            System.out.println("  Output  : " + _tcShow(_tcSol.beforeAndAfterPuzzles(phrases)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"ab ba ab\",\"ba ab ba\"]");
        System.out.println();
    }
}