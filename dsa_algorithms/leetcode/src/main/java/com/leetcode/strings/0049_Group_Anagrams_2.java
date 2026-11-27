package com.leetcode.strings;

class Solution0049_2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> d = new HashMap<>();
        for (String s : strs) {
            int[] cnt = new int[26];
            for (int i = 0; i < s.length(); ++i) {
                ++cnt[s.charAt(i) - 'a'];
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; ++i) {
                if (cnt[i] > 0) {
                    sb.append((char) ('a' + i)).append(cnt[i]);
                }
            }
            String k = sb.toString();
            d.computeIfAbsent(k, key -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(d.values());
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0049_2 _tcSol = new Solution0049_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "strs = [\"eat\",\"tea\",\"tan\",\"ate\",\"nat\",\"bat\"]");
        try {
            String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
            System.out.println("  Output  : " + _tcShow(_tcSol.groupAnagrams(strs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[\"bat\"],[\"nat\",\"tan\"],[\"ate\",\"eat\",\"tea\"]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "strs = [\"\"]");
        try {
            String[] strs = new String[]{""};
            System.out.println("  Output  : " + _tcShow(_tcSol.groupAnagrams(strs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[\"\"]]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "strs = [\"a\"]");
        try {
            String[] strs = new String[]{"a"};
            System.out.println("  Output  : " + _tcShow(_tcSol.groupAnagrams(strs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[\"a\"]]");
        System.out.println();
    }
}