package com.leetcode.arrays_hashing_greedy;

class Solution0943 {
    public String shortestSuperstring(String[] words) {
        int n = words.length;
        int[][] g = new int[n][n];
        for (int i = 0; i < n; ++i) {
            String a = words[i];
            for (int j = 0; j < n; ++j) {
                String b = words[j];
                if (i != j) {
                    for (int k = Math.min(a.length(), b.length()); k > 0; --k) {
                        if (a.substring(a.length() - k).equals(b.substring(0, k))) {
                            g[i][j] = k;
                            break;
                        }
                    }
                }
            }
        }
        int[][] dp = new int[1 << n][n];
        int[][] p = new int[1 << n][n];
        for (int i = 0; i < 1 << n; ++i) {
            Arrays.fill(p[i], -1);
            for (int j = 0; j < n; ++j) {
                if (((i >> j) & 1) == 1) {
                    int pi = i ^ (1 << j);
                    for (int k = 0; k < n; ++k) {
                        if (((pi >> k) & 1) == 1) {
                            int v = dp[pi][k] + g[k][j];
                            if (v > dp[i][j]) {
                                dp[i][j] = v;
                                p[i][j] = k;
                            }
                        }
                    }
                }
            }
        }
        int j = 0;
        for (int i = 0; i < n; ++i) {
            if (dp[(1 << n) - 1][i] > dp[(1 << n) - 1][j]) {
                j = i;
            }
        }
        List<Integer> arr = new ArrayList<>();
        arr.add(j);
        for (int i = (1 << n) - 1; p[i][j] != -1;) {
            int k = i;
            i ^= (1 << j);
            j = p[k][j];
            arr.add(j);
        }
        Set<Integer> vis = new HashSet<>(arr);
        for (int i = 0; i < n; ++i) {
            if (!vis.contains(i)) {
                arr.add(i);
            }
        }
        Collections.reverse(arr);
        StringBuilder ans = new StringBuilder(words[arr.get(0)]);
        for (int i = 1; i < n; ++i) {
            int k = g[arr.get(i - 1)][arr.get(i)];
            ans.append(words[arr.get(i)].substring(k));
        }
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0943 _tcSol = new Solution0943();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"alex\",\"loves\",\"leetcode\"]");
        try {
            String[] words = new String[]{"alex", "loves", "leetcode"};
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestSuperstring(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"alexlovesleetcode\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"catg\",\"ctaagt\",\"gcta\",\"ttca\",\"atgcatc\"]");
        try {
            String[] words = new String[]{"catg", "ctaagt", "gcta", "ttca", "atgcatc"};
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestSuperstring(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"gctaagttcatgcatc\"");
        System.out.println();
    }
}