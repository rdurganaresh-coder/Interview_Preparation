package com.leetcode.arrays_hashing_greedy;

class Solution0792_3 {
    private List<Integer>[] d = new List[26];

    public int numMatchingSubseq(String s, String[] words) {
        Arrays.setAll(d, k -> new ArrayList<>());
        for (int i = 0; i < s.length(); ++i) {
            d[s.charAt(i) - 'a'].add(i);
        }
        int ans = 0;
        for (String w : words) {
            if (check(w)) {
                ++ans;
            }
        }
        return ans;
    }

    private boolean check(String w) {
        int i = -1;
        for (int k = 0; k < w.length(); ++k) {
            int c = w.charAt(k) - 'a';
            int j = search(d[c], i);
            if (j == d[c].size()) {
                return false;
            }
            i = d[c].get(j);
        }
        return true;
    }

    private int search(List<Integer> t, int x) {
        int left = 0, right = t.size();
        while (left < right) {
            int mid = (left + right) >> 1;
            if (t.get(mid) > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0792_3 _tcSol = new Solution0792_3();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abcde\", words = [\"a\",\"bb\",\"acd\",\"ace\"]");
        try {
            String s = "abcde";
            String[] words = new String[]{"a", "bb", "acd", "ace"};
            System.out.println("  Output  : " + _tcShow(_tcSol.numMatchingSubseq(s, words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"dsahjpjauf\", words = [\"ahjpjau\",\"ja\",\"ahbwzgqnuk\",\"tnmlanowax\"]");
        try {
            String s = "dsahjpjauf";
            String[] words = new String[]{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"};
            System.out.println("  Output  : " + _tcShow(_tcSol.numMatchingSubseq(s, words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}