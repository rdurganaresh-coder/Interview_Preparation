package com.leetcode.strings;

class Solution0884 {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String s : s1.split(" ")) {
            cnt.merge(s, 1, Integer::sum);
        }
        for (String s : s2.split(" ")) {
            cnt.merge(s, 1, Integer::sum);
        }
        List<String> ans = new ArrayList<>();
        for (var e : cnt.entrySet()) {
            if (e.getValue() == 1) {
                ans.add(e.getKey());
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
        Solution0884 _tcSol = new Solution0884();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s1 = \"this apple is sweet\", s2 = \"this apple is sour\"");
        try {
            String s1 = "this apple is sweet";
            String s2 = "this apple is sour";
            System.out.println("  Output  : " + _tcShow(_tcSol.uncommonFromSentences(s1, s2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"sweet\",\"sour\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s1 = \"apple apple\", s2 = \"banana\"");
        try {
            String s1 = "apple apple";
            String s2 = "banana";
            System.out.println("  Output  : " + _tcShow(_tcSol.uncommonFromSentences(s1, s2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"banana\"]");
        System.out.println();
    }
}