package com.leetcode.strings;

class Solution2451 {
    public String oddString(String[] words) {
        var d = new HashMap<String, List<String>>();
        for (var s : words) {
            int m = s.length();
            var cs = new char[m - 1];
            for (int i = 0; i < m - 1; ++i) {
                cs[i] = (char) (s.charAt(i + 1) - s.charAt(i));
            }
            var t = String.valueOf(cs);
            d.putIfAbsent(t, new ArrayList<>());
            d.get(t).add(s);
        }
        for (var ss : d.values()) {
            if (ss.size() == 1) {
                return ss.get(0);
            }
        }
        return "";
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2451 _tcSol = new Solution2451();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"adc\",\"wzy\",\"abc\"]");
        try {
            String[] words = new String[]{"adc", "wzy", "abc"};
            System.out.println("  Output  : " + _tcShow(_tcSol.oddString(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"abc\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"aaa\",\"bob\",\"ccc\",\"ddd\"]");
        try {
            String[] words = new String[]{"aaa", "bob", "ccc", "ddd"};
            System.out.println("  Output  : " + _tcShow(_tcSol.oddString(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"bob\"");
        System.out.println();
    }
}