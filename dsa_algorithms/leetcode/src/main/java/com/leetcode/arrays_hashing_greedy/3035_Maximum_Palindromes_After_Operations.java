package com.leetcode.arrays_hashing_greedy;

class Solution3035 {
    public int maxPalindromesAfterOperations(String[] words) {
        int s = 0, mask = 0;
        for (var w : words) {
            s += w.length();
            for (var c : w.toCharArray()) {
                mask ^= 1 << (c - 'a');
            }
        }
        s -= Integer.bitCount(mask);
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int ans = 0;
        for (var w : words) {
            s -= w.length() / 2 * 2;
            if (s < 0) {
                break;
            }
            ++ans;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3035 _tcSol = new Solution3035();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"abbb\",\"ba\",\"aa\"]");
        try {
            String[] words = new String[]{"abbb", "ba", "aa"};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxPalindromesAfterOperations(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"abc\",\"ab\"]");
        try {
            String[] words = new String[]{"abc", "ab"};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxPalindromesAfterOperations(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "words = [\"cd\",\"ef\",\"a\"]");
        try {
            String[] words = new String[]{"cd", "ef", "a"};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxPalindromesAfterOperations(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}