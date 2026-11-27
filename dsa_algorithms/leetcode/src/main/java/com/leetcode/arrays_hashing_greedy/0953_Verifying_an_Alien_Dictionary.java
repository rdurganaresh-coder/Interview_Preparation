package com.leetcode.arrays_hashing_greedy;

class Solution0953 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] m = new int[26];
        for (int i = 0; i < 26; ++i) {
            m[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < 20; ++i) {
            int prev = -1;
            boolean valid = true;
            for (String x : words) {
                int curr = i >= x.length() ? -1 : m[x.charAt(i) - 'a'];
                if (prev > curr) {
                    return false;
                }
                if (prev == curr) {
                    valid = false;
                }
                prev = curr;
            }
            if (valid) {
                break;
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0953 _tcSol = new Solution0953();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"hello\",\"leetcode\"], order = \"hlabcdefgijkmnopqrstuvwxyz\"");
        try {
            String[] words = new String[]{"hello", "leetcode"};
            String order = "hlabcdefgijkmnopqrstuvwxyz";
            System.out.println("  Output  : " + _tcShow(_tcSol.isAlienSorted(words, order)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"word\",\"world\",\"row\"], order = \"worldabcefghijkmnpqstuvxyz\"");
        try {
            String[] words = new String[]{"word", "world", "row"};
            String order = "worldabcefghijkmnpqstuvxyz";
            System.out.println("  Output  : " + _tcShow(_tcSol.isAlienSorted(words, order)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "words = [\"apple\",\"app\"], order = \"abcdefghijklmnopqrstuvwxyz\"");
        try {
            String[] words = new String[]{"apple", "app"};
            String order = "abcdefghijklmnopqrstuvwxyz";
            System.out.println("  Output  : " + _tcShow(_tcSol.isAlienSorted(words, order)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}