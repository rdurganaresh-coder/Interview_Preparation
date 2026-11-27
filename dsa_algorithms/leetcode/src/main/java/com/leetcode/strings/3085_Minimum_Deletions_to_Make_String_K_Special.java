package com.leetcode.strings;

class Solution3085 {
    private List<Integer> nums = new ArrayList<>();

    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        int n = word.length();
        for (int i = 0; i < n; ++i) {
            ++freq[word.charAt(i) - 'a'];
        }
        for (int v : freq) {
            if (v > 0) {
                nums.add(v);
            }
        }
        int ans = n;
        for (int i = 0; i <= n; ++i) {
            ans = Math.min(ans, f(i, k));
        }
        return ans;
    }

    private int f(int v, int k) {
        int ans = 0;
        for (int x : nums) {
            if (x < v) {
                ans += x;
            } else if (x > v + k) {
                ans += x - v - k;
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
        Solution3085 _tcSol = new Solution3085();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word = \"aabcaba\", k = 0");
        try {
            String word = "aabcaba";
            int k = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumDeletions(word, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word = \"dabdcbdcdcd\", k = 2");
        try {
            String word = "dabdcbdcdcd";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumDeletions(word, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "word = \"aaabaaa\", k = 2");
        try {
            String word = "aaabaaa";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumDeletions(word, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}