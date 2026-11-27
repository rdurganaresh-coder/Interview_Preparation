package com.leetcode.arrays_hashing_greedy;

class Solution0187 {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> cnt = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < s.length() - 10 + 1; ++i) {
            String t = s.substring(i, i + 10);
            if (cnt.merge(t, 1, Integer::sum) == 2) {
                ans.add(t);
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
        Solution0187 _tcSol = new Solution0187();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT\"");
        try {
            String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
            System.out.println("  Output  : " + _tcShow(_tcSol.findRepeatedDnaSequences(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"AAAAACCCCC\",\"CCCCCAAAAA\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"AAAAAAAAAAAAA\"");
        try {
            String s = "AAAAAAAAAAAAA";
            System.out.println("  Output  : " + _tcShow(_tcSol.findRepeatedDnaSequences(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"AAAAAAAAAA\"]");
        System.out.println();
    }
}