package com.leetcode.sliding_window_two_pointers;

class Solution1839 {
    public int longestBeautifulSubstring(String word) {
        int n = word.length();
        List<Node1839> arr = new ArrayList<>();
        for (int i = 0; i < n;) {
            int j = i;
            while (j < n && word.charAt(j) == word.charAt(i)) {
                ++j;
            }
            arr.add(new Node1839(word.charAt(i), j - i));
            i = j;
        }
        int ans = 0;
        for (int i = 0; i < arr.size() - 4; ++i) {
            Node1839 a = arr.get(i), b = arr.get(i + 1), c = arr.get(i + 2), d = arr.get(i + 3),
                 e = arr.get(i + 4);
            if (a.c == 'a' && b.c == 'e' && c.c == 'i' && d.c == 'o' && e.c == 'u') {
                ans = Math.max(ans, a.v + b.v + c.v + d.v + e.v);
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
        Solution1839 _tcSol = new Solution1839();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word = \"aeiaaioaaaaeiiiiouuuooaauuaeiu\"");
        try {
            String word = "aeiaaioaaaaeiiiiouuuooaauuaeiu";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestBeautifulSubstring(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word = \"aeeeiiiioooauuuaeiou\"");
        try {
            String word = "aeeeiiiioooauuuaeiou";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestBeautifulSubstring(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "word = \"a\"");
        try {
            String word = "a";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestBeautifulSubstring(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}

class Node1839 {
    char c;
    int v;

    Node1839(char c, int v) {
        this.c = c;
        this.v = v;
    }
}