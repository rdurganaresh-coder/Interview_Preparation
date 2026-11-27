package com.leetcode.strings;

class Solution2284 {
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> cnt = new HashMap<>(senders.length);
        for (int i = 0; i < messages.length; ++i) {
            int v = 1;
            for (int j = 0; j < messages[i].length(); ++j) {
                if (messages[i].charAt(j) == ' ') {
                    ++v;
                }
            }
            cnt.merge(senders[i], v, Integer::sum);
        }
        String ans = senders[0];
        for (var e : cnt.entrySet()) {
            String k = e.getKey();
            int v = e.getValue();
            if (cnt.get(ans) < v || (cnt.get(ans) == v && ans.compareTo(k) < 0)) {
                ans = k;
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
        Solution2284 _tcSol = new Solution2284();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "messages = [\"Hello userTwooo\",\"Hi userThree\",\"Wonderful day Alice\",\"Nice day userThree\"], senders = [\"Alice\",\"userTwo\",\"userThree\",\"Alice\"]");
        try {
            String[] messages = new String[]{"Hello userTwooo", "Hi userThree", "Wonderful day Alice", "Nice day userThree"};
            String[] senders = new String[]{"Alice", "userTwo", "userThree", "Alice"};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestWordCount(messages, senders)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"Alice\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "messages = [\"How is leetcode for everyone\",\"Leetcode is useful for practice\"], senders = [\"Bob\",\"Charlie\"]");
        try {
            String[] messages = new String[]{"How is leetcode for everyone", "Leetcode is useful for practice"};
            String[] senders = new String[]{"Bob", "Charlie"};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestWordCount(messages, senders)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"Charlie\"");
        System.out.println();
    }
}