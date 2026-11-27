package com.leetcode.sliding_window_two_pointers;

class Solution2301 {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        Map<Character, Set<Character>> d = new HashMap<>();
        for (var e : mappings) {
            d.computeIfAbsent(e[0], k -> new HashSet<>()).add(e[1]);
        }
        int m = s.length(), n = sub.length();
        for (int i = 0; i < m - n + 1; ++i) {
            boolean ok = true;
            for (int j = 0; j < n && ok; ++j) {
                char a = s.charAt(i + j), b = sub.charAt(j);
                if (a != b && !d.getOrDefault(b, Collections.emptySet()).contains(a)) {
                    ok = false;
                }
            }
            if (ok) {
                return true;
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2301 _tcSol = new Solution2301();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"fool3e7bar\", sub = \"leet\", mappings = [[\"e\",\"3\"],[\"t\",\"7\"],[\"t\",\"8\"]]");
        try {
            String s = "fool3e7bar";
            String sub = "leet";
            char[][] mappings = new char[][]{new char[]{'e', '3'}, new char[]{'t', '7'}, new char[]{'t', '8'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.matchReplacement(s, sub, mappings)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"fooleetbar\", sub = \"f00l\", mappings = [[\"o\",\"0\"]]");
        try {
            String s = "fooleetbar";
            String sub = "f00l";
            char[][] mappings = new char[][]{new char[]{'o', '0'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.matchReplacement(s, sub, mappings)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"Fool33tbaR\", sub = \"leetd\", mappings = [[\"e\",\"3\"],[\"t\",\"7\"],[\"t\",\"8\"],[\"d\",\"b\"],[\"p\",\"b\"]]");
        try {
            String s = "Fool33tbaR";
            String sub = "leetd";
            char[][] mappings = new char[][]{new char[]{'e', '3'}, new char[]{'t', '7'}, new char[]{'t', '8'}, new char[]{'d', 'b'}, new char[]{'p', 'b'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.matchReplacement(s, sub, mappings)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}