package com.leetcode.sliding_window_two_pointers;

class Solution2950_2 {
    public int countDivisibleSubstrings(String word) {
        String[] d = {"ab", "cde", "fgh", "ijk", "lmn", "opq", "rst", "uvw", "xyz"};
        int[] mp = new int[26];
        for (int i = 0; i < d.length; ++i) {
            for (char c : d[i].toCharArray()) {
                mp[c - 'a'] = i + 1;
            }
        }
        int ans = 0;
        char[] cs = word.toCharArray();
        for (int i = 1; i < 10; ++i) {
            Map<Integer, Integer> cnt = new HashMap<>();
            cnt.put(0, 1);
            int s = 0;
            for (char c : cs) {
                s += mp[c - 'a'] - i;
                ans += cnt.getOrDefault(s, 0);
                cnt.merge(s, 1, Integer::sum);
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
        Solution2950_2 _tcSol = new Solution2950_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word = \"asdf\"");
        try {
            String word = "asdf";
            System.out.println("  Output  : " + _tcShow(_tcSol.countDivisibleSubstrings(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word = \"bdh\"");
        try {
            String word = "bdh";
            System.out.println("  Output  : " + _tcShow(_tcSol.countDivisibleSubstrings(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "word = \"abcd\"");
        try {
            String word = "abcd";
            System.out.println("  Output  : " + _tcShow(_tcSol.countDivisibleSubstrings(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}