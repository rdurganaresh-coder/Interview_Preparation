package com.leetcode.arrays_hashing_greedy;

class Solution3003_2 {
    public int maxPartitionsAfterOperations(String s, int k) {
        int n = s.length();
        int[] masks = new int[n];
        for (int i = 0; i < n; ++i) {
            masks[i] = 1 << (s.charAt(i) - 'a');
        }
        List<Set<Integer>> reach = new ArrayList<>();
        List<Map<Integer, Integer>> f = new ArrayList<>();
        for (int i = 0; i <= n; ++i) {
            reach.add(new HashSet<>());
            f.add(new HashMap<>());
        }
        reach.get(0).add(1);
        for (int i = 0; i < n; ++i) {
            int v = masks[i];
            for (int key : reach.get(i)) {
                int cur = key >> 1, t = key & 1;
                add(reach.get(i + 1), cur, t, v, k);
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            int v = masks[i];
            for (int key : reach.get(i)) {
                int cur = key >> 1, t = key & 1;
                int nxt = cur | v;
                int ans = Integer.bitCount(nxt) > k ? value(f, n, i + 1, (v << 1) | t) + 1
                                                    : value(f, n, i + 1, (nxt << 1) | t);
                if (t == 1) {
                    for (int j = 0; j < 26; ++j) {
                        int bit = 1 << j;
                        nxt = cur | bit;
                        if (Integer.bitCount(nxt) > k) {
                            ans = Math.max(ans, value(f, n, i + 1, bit << 1) + 1);
                        } else {
                            ans = Math.max(ans, value(f, n, i + 1, nxt << 1));
                        }
                    }
                }
                f.get(i).put(key, ans);
            }
        }
        return f.get(0).get(1);
    }

    private void add(Set<Integer> reach, int cur, int t, int v, int k) {
        int nxt = cur | v;
        if (Integer.bitCount(nxt) > k) {
            reach.add((v << 1) | t);
        } else {
            reach.add((nxt << 1) | t);
        }
        if (t == 1) {
            for (int j = 0; j < 26; ++j) {
                int bit = 1 << j;
                nxt = cur | bit;
                if (Integer.bitCount(nxt) > k) {
                    reach.add(bit << 1);
                } else {
                    reach.add(nxt << 1);
                }
            }
        }
    }

    private int value(List<Map<Integer, Integer>> f, int n, int i, int key) {
        if (i == n) {
            return 1;
        }
        return f.get(i).get(key);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3003_2 _tcSol = new Solution3003_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"accca\", k = 2");
        try {
            String s = "accca";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxPartitionsAfterOperations(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"aabaab\", k = 3");
        try {
            String s = "aabaab";
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxPartitionsAfterOperations(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"xxyz\", k = 1");
        try {
            String s = "xxyz";
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxPartitionsAfterOperations(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}
