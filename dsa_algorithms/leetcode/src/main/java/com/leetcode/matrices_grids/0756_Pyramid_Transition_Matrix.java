package com.leetcode.matrices_grids;

class Solution0756 {
    private final int[][] d = new int[7][7];
    private final Map<String, Boolean> f = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String s : allowed) {
            int a = s.charAt(0) - 'A', b = s.charAt(1) - 'A';
            d[a][b] |= 1 << (s.charAt(2) - 'A');
        }
        return dfs(bottom, new StringBuilder());
    }

    private boolean dfs(String s, StringBuilder t) {
        if (s.length() == 1) {
            return true;
        }
        if (t.length() + 1 == s.length()) {
            return dfs(t.toString(), new StringBuilder());
        }
        String k = s + "." + t.toString();
        Boolean res = f.get(k);
        if (res != null) {
            return res;
        }
        int a = s.charAt(t.length()) - 'A', b = s.charAt(t.length() + 1) - 'A';
        int cs = d[a][b];
        for (int i = 0; i < 7; ++i) {
            if (((cs >> i) & 1) == 1) {
                t.append((char) ('A' + i));
                if (dfs(s, t)) {
                    f.put(k, true);
                    return true;
                }
                t.setLength(t.length() - 1);
            }
        }
        f.put(k, false);
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution0756 _tcSol = new Solution0756();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "bottom = \"BCD\", allowed = [\"BCC\",\"CDE\",\"CEA\",\"FFF\"]");
        try {
            String bottom = "BCD";
            List<String> allowed = _tcL("BCC", "CDE", "CEA", "FFF");
            System.out.println("  Output  : " + _tcShow(_tcSol.pyramidTransition(bottom, allowed)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "bottom = \"AAAA\", allowed = [\"AAB\",\"AAC\",\"BCD\",\"BBE\",\"DEF\"]");
        try {
            String bottom = "AAAA";
            List<String> allowed = _tcL("AAB", "AAC", "BCD", "BBE", "DEF");
            System.out.println("  Output  : " + _tcShow(_tcSol.pyramidTransition(bottom, allowed)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
