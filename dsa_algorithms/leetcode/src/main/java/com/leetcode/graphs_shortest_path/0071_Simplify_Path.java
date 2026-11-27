package com.leetcode.graphs_shortest_path;

class Solution0071 {
    public String simplifyPath(String path) {
        Deque<String> stk = new ArrayDeque<>();
        for (String s : path.split("/")) {
            if ("".equals(s) || ".".equals(s)) {
                continue;
            }
            if ("..".equals(s)) {
                stk.pollLast();
            } else {
                stk.offerLast(s);
            }
        }
        return "/" + String.join("/", stk);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0071 _tcSol = new Solution0071();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "path = \"/home/\"");
        try {
            String path = "/home/";
            System.out.println("  Output  : " + _tcShow(_tcSol.simplifyPath(path)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"/home\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "path = \"/home//foo/\"");
        try {
            String path = "/home//foo/";
            System.out.println("  Output  : " + _tcShow(_tcSol.simplifyPath(path)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"/home/foo\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "path = \"/home/user/Documents/../Pictures\"");
        try {
            String path = "/home/user/Documents/../Pictures";
            System.out.println("  Output  : " + _tcShow(_tcSol.simplifyPath(path)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"/home/user/Pictures\"");
        System.out.println();

        System.out.println("Test 4");
        System.out.println("  Input   : " + "path = \"/../\"");
        try {
            String path = "/../";
            System.out.println("  Output  : " + _tcShow(_tcSol.simplifyPath(path)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"/\"");
        System.out.println();

        System.out.println("Test 5");
        System.out.println("  Input   : " + "path = \"/.../a/../b/c/../d/./\"");
        try {
            String path = "/.../a/../b/c/../d/./";
            System.out.println("  Output  : " + _tcShow(_tcSol.simplifyPath(path)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"/.../b/d\"");
        System.out.println();
    }
}