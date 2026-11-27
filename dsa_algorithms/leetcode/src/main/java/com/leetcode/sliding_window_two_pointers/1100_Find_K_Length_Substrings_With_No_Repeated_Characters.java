package com.leetcode.sliding_window_two_pointers;

class Solution1100 {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int n = s.length();
        if (n < k) {
            return 0;
        }
        Map<Character, Integer> cnt = new HashMap<>(k);
        for (int i = 0; i < k; ++i) {
            cnt.merge(s.charAt(i), 1, Integer::sum);
        }
        int ans = cnt.size() == k ? 1 : 0;
        for (int i = k; i < n; ++i) {
            cnt.merge(s.charAt(i), 1, Integer::sum);
            if (cnt.merge(s.charAt(i - k), -1, Integer::sum) == 0) {
                cnt.remove(s.charAt(i - k));
            }
            ans += cnt.size() == k ? 1 : 0;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1100 _tcSol = new Solution1100();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"havefunonleetcode\", k = 5");
        try {
            String s = "havefunonleetcode";
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.numKLenSubstrNoRepeats(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"home\", k = 5");
        try {
            String s = "home";
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.numKLenSubstrNoRepeats(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}