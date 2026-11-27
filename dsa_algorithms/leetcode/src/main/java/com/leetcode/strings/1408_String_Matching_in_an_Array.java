package com.leetcode.strings;

class Solution1408 {
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i != j && words[j].contains(words[i])) {
                    ans.add(words[i]);
                    break;
                }
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
        Solution1408 _tcSol = new Solution1408();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"mass\",\"as\",\"hero\",\"superhero\"]");
        try {
            String[] words = new String[]{"mass", "as", "hero", "superhero"};
            System.out.println("  Output  : " + _tcShow(_tcSol.stringMatching(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"as\",\"hero\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"leetcode\",\"et\",\"code\"]");
        try {
            String[] words = new String[]{"leetcode", "et", "code"};
            System.out.println("  Output  : " + _tcShow(_tcSol.stringMatching(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"et\",\"code\"]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "words = [\"blue\",\"green\",\"bu\"]");
        try {
            String[] words = new String[]{"blue", "green", "bu"};
            System.out.println("  Output  : " + _tcShow(_tcSol.stringMatching(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}