package com.leetcode.arrays_hashing_greedy;

class Solution2423 {
    public boolean equalFrequency(String word) {
        int[] cnt = new int[26];
        for (int i = 0; i < word.length(); ++i) {
            ++cnt[word.charAt(i) - 'a'];
        }
        for (int i = 0; i < 26; ++i) {
            if (cnt[i] > 0) {
                --cnt[i];
                int x = 0;
                boolean ok = true;
                for (int v : cnt) {
                    if (v == 0) {
                        continue;
                    }
                    if (x > 0 && v != x) {
                        ok = false;
                        break;
                    }
                    x = v;
                }
                if (ok) {
                    return true;
                }
                ++cnt[i];
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2423 _tcSol = new Solution2423();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word = \"abcc\"");
        try {
            String word = "abcc";
            System.out.println("  Output  : " + _tcShow(_tcSol.equalFrequency(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word = \"aazz\"");
        try {
            String word = "aazz";
            System.out.println("  Output  : " + _tcShow(_tcSol.equalFrequency(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}