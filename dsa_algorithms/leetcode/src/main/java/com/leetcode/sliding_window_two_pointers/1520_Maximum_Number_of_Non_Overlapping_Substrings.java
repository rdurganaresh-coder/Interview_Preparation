package com.leetcode.sliding_window_two_pointers;

class Solution1520 {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        for (int i = 0; i < n; ++i) {
            int x = s.charAt(i) - 'a';
            if (first[x] == -1) {
                first[x] = i;
            }
            last[x] = i;
        }
        List<int[]> segs = new ArrayList<>();
        for (int x = 0; x < 26; ++x) {
            if (first[x] == -1) {
                continue;
            }
            int l = first[x], r = last[x];
            int i = l;
            for (; i <= r; ++i) {
                int y = s.charAt(i) - 'a';
                if (first[y] < l) {
                    break;
                }
                r = Math.max(r, last[y]);
            }
            if (i > r) {
                segs.add(new int[] {l, r});
            }
        }
        segs.sort((a, b) -> a[1] - b[1]);
        List<String> ans = new ArrayList<>();
        int end = -1;
        for (int[] e : segs) {
            int l = e[0], r = e[1];
            if (l > end) {
                ans.add(s.substring(l, r + 1));
                end = r;
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
        Solution1520 _tcSol = new Solution1520();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"adefaddaccc\"");
        try {
            String s = "adefaddaccc";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxNumOfSubstrings(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"e\",\"f\",\"ccc\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abbaccd\"");
        try {
            String s = "abbaccd";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxNumOfSubstrings(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"d\",\"bb\",\"cc\"]");
        System.out.println();
    }
}
