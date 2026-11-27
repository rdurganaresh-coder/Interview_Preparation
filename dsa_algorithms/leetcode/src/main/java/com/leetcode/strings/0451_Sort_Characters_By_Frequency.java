package com.leetcode.strings;

class Solution0451 {
    public String frequencySort(String s) {
        Map<Character, Integer> cnt = new HashMap<>(52);
        for (int i = 0; i < s.length(); ++i) {
            cnt.merge(s.charAt(i), 1, Integer::sum);
        }
        List<Character> cs = new ArrayList<>(cnt.keySet());
        cs.sort((a, b) -> cnt.get(b) - cnt.get(a));
        StringBuilder ans = new StringBuilder();
        for (char c : cs) {
            for (int v = cnt.get(c); v > 0; --v) {
                ans.append(c);
            }
        }
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0451 _tcSol = new Solution0451();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"tree\"");
        try {
            String s = "tree";
            System.out.println("  Output  : " + _tcShow(_tcSol.frequencySort(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"eert\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"cccaaa\"");
        try {
            String s = "cccaaa";
            System.out.println("  Output  : " + _tcShow(_tcSol.frequencySort(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"aaaccc\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"Aabb\"");
        try {
            String s = "Aabb";
            System.out.println("  Output  : " + _tcShow(_tcSol.frequencySort(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"bbAa\"");
        System.out.println();
    }
}