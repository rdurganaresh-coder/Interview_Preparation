package com.leetcode.strings;

class Solution1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int n = words.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = f(words[i]);
        }
        Arrays.sort(nums);
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; ++i) {
            int x = f(queries[i]);
            int l = 0, r = n;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (nums[mid] > x) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            ans[i] = n - l;
        }
        return ans;
    }

    private int f(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++cnt[s.charAt(i) - 'a'];
        }
        for (int x : cnt) {
            if (x > 0) {
                return x;
            }
        }
        return 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1170 _tcSol = new Solution1170();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "queries = [\"cbd\"], words = [\"zaaaz\"]");
        try {
            String[] queries = new String[]{"cbd"};
            String[] words = new String[]{"zaaaz"};
            System.out.println("  Output  : " + _tcShow(_tcSol.numSmallerByFrequency(queries, words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "queries = [\"bbb\",\"cc\"], words = [\"a\",\"aa\",\"aaa\",\"aaaa\"]");
        try {
            String[] queries = new String[]{"bbb", "cc"};
            String[] words = new String[]{"a", "aa", "aaa", "aaaa"};
            System.out.println("  Output  : " + _tcShow(_tcSol.numSmallerByFrequency(queries, words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2]");
        System.out.println();
    }
}