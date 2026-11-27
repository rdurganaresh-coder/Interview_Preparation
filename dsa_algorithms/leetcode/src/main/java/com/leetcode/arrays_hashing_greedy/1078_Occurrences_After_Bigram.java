package com.leetcode.arrays_hashing_greedy;

class Solution1078 {

    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length - 2; ++i) {
            if (first.equals(words[i]) && second.equals(words[i + 1])) {
                ans.add(words[i + 2]);
            }
        }
        return ans.toArray(new String[0]);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1078 _tcSol = new Solution1078();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "text = \"alice is a good girl she is a good student\", first = \"a\", second = \"good\"");
        try {
            String text = "alice is a good girl she is a good student";
            String first = "a";
            String second = "good";
            System.out.println("  Output  : " + _tcShow(_tcSol.findOcurrences(text, first, second)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"girl\",\"student\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "text = \"we will we will rock you\", first = \"we\", second = \"will\"");
        try {
            String text = "we will we will rock you";
            String first = "we";
            String second = "will";
            System.out.println("  Output  : " + _tcShow(_tcSol.findOcurrences(text, first, second)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"we\",\"rock\"]");
        System.out.println();
    }
}