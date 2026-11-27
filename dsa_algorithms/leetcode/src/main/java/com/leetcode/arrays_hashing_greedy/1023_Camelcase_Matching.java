package com.leetcode.arrays_hashing_greedy;

class Solution1023 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        for (var q : queries) {
            ans.add(check(q, pattern));
        }
        return ans;
    }

    private boolean check(String s, String t) {
        int m = s.length(), n = t.length();
        int i = 0, j = 0;
        for (; j < n; ++i, ++j) {
            while (i < m && s.charAt(i) != t.charAt(j) && Character.isLowerCase(s.charAt(i))) {
                ++i;
            }
            if (i == m || s.charAt(i) != t.charAt(j)) {
                return false;
            }
        }
        while (i < m && Character.isLowerCase(s.charAt(i))) {
            ++i;
        }
        return i == m;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1023 _tcSol = new Solution1023();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "queries = [\"FooBar\",\"FooBarTest\",\"FootBall\",\"FrameBuffer\",\"ForceFeedBack\"], pattern = \"FB\"");
        try {
            String[] queries = new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
            String pattern = "FB";
            System.out.println("  Output  : " + _tcShow(_tcSol.camelMatch(queries, pattern)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[true,false,true,true,false]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "queries = [\"FooBar\",\"FooBarTest\",\"FootBall\",\"FrameBuffer\",\"ForceFeedBack\"], pattern = \"FoBa\"");
        try {
            String[] queries = new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
            String pattern = "FoBa";
            System.out.println("  Output  : " + _tcShow(_tcSol.camelMatch(queries, pattern)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[true,false,true,false,false]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "queries = [\"FooBar\",\"FooBarTest\",\"FootBall\",\"FrameBuffer\",\"ForceFeedBack\"], pattern = \"FoBaT\"");
        try {
            String[] queries = new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
            String pattern = "FoBaT";
            System.out.println("  Output  : " + _tcShow(_tcSol.camelMatch(queries, pattern)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[false,true,false,false,false]");
        System.out.println();
    }
}