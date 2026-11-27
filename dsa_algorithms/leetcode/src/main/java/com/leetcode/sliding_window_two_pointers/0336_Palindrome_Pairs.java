package com.leetcode.sliding_window_two_pointers;

class Solution0336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> d = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            d.put(words[i], i);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < words.length; ++i) {
            String w = words[i];
            int m = w.length();
            for (int j = 0; j <= m; ++j) {
                String a = w.substring(0, j);
                String b = w.substring(j);
                String ra = new StringBuilder(a).reverse().toString();
                String rb = new StringBuilder(b).reverse().toString();
                if (d.containsKey(ra) && d.get(ra) != i && b.equals(rb)) {
                    ans.add(Arrays.asList(i, d.get(ra)));
                }
                if (j > 0 && d.containsKey(rb) && d.get(rb) != i && a.equals(ra)) {
                    ans.add(Arrays.asList(d.get(rb), i));
                }
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
        Solution0336 _tcSol = new Solution0336();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"abcd\",\"dcba\",\"lls\",\"s\",\"sssll\"]");
        try {
            String[] words = new String[]{"abcd", "dcba", "lls", "s", "sssll"};
            System.out.println("  Output  : " + _tcShow(_tcSol.palindromePairs(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,1],[1,0],[3,2],[2,4]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"bat\",\"tab\",\"cat\"]");
        try {
            String[] words = new String[]{"bat", "tab", "cat"};
            System.out.println("  Output  : " + _tcShow(_tcSol.palindromePairs(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,1],[1,0]]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "words = [\"a\",\"\"]");
        try {
            String[] words = new String[]{"a", ""};
            System.out.println("  Output  : " + _tcShow(_tcSol.palindromePairs(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,1],[1,0]]");
        System.out.println();
    }
}
