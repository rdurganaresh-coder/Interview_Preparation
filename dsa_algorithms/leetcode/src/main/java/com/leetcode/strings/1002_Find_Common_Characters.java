package com.leetcode.strings;

class Solution1002 {
    public List<String> commonChars(String[] words) {
        int[] cnt = new int[26];
        Arrays.fill(cnt, 20000);
        for (var w : words) {
            int[] t = new int[26];
            for (int i = 0; i < w.length(); ++i) {
                ++t[w.charAt(i) - 'a'];
            }
            for (int i = 0; i < 26; ++i) {
                cnt[i] = Math.min(cnt[i], t[i]);
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            ans.addAll(Collections.nCopies(cnt[i], String.valueOf((char) ('a' + i))));
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1002 _tcSol = new Solution1002();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"bella\",\"label\",\"roller\"]");
        try {
            String[] words = new String[]{"bella", "label", "roller"};
            System.out.println("  Output  : " + _tcShow(_tcSol.commonChars(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"e\",\"l\",\"l\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"cool\",\"lock\",\"cook\"]");
        try {
            String[] words = new String[]{"cool", "lock", "cook"};
            System.out.println("  Output  : " + _tcShow(_tcSol.commonChars(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"c\",\"o\"]");
        System.out.println();
    }
}
