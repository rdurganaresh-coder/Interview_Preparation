package com.leetcode.sliding_window_two_pointers;

class Solution0828 {
    public int uniqueLetterString(String s) {
        List<Integer>[] d = new List[26];
        Arrays.setAll(d, k -> new ArrayList<>());
        for (int i = 0; i < 26; ++i) {
            d[i].add(-1);
        }
        for (int i = 0; i < s.length(); ++i) {
            d[s.charAt(i) - 'A'].add(i);
        }
        int ans = 0;
        for (var v : d) {
            v.add(s.length());
            for (int i = 1; i < v.size() - 1; ++i) {
                ans += (v.get(i) - v.get(i - 1)) * (v.get(i + 1) - v.get(i));
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
        Solution0828 _tcSol = new Solution0828();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"ABC\"");
        try {
            String s = "ABC";
            System.out.println("  Output  : " + _tcShow(_tcSol.uniqueLetterString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"ABA\"");
        try {
            String s = "ABA";
            System.out.println("  Output  : " + _tcShow(_tcSol.uniqueLetterString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"LEETCODE\"");
        try {
            String s = "LEETCODE";
            System.out.println("  Output  : " + _tcShow(_tcSol.uniqueLetterString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "92");
        System.out.println();
    }
}