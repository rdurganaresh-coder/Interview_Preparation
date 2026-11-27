package com.leetcode.arrays_hashing_greedy;

class Solution0929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> s = new HashSet<>();
        for (String email : emails) {
            String[] parts = email.split("@");
            String local = parts[0];
            String domain = parts[1];
            StringBuilder t = new StringBuilder();
            for (char c : local.toCharArray()) {
                if (c == '.') {
                    continue;
                }
                if (c == '+') {
                    break;
                }
                t.append(c);
            }
            s.add(t.toString() + "@" + domain);
        }
        return s.size();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0929 _tcSol = new Solution0929();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "emails = [\"test.email+alex@leetcode.com\",\"test.e.mail+bob.cathy@leetcode.com\",\"testemail+david@lee.tcode.com\"]");
        try {
            String[] emails = new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
            System.out.println("  Output  : " + _tcShow(_tcSol.numUniqueEmails(emails)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "emails = [\"a@leetcode.com\",\"b@leetcode.com\",\"c@leetcode.com\"]");
        try {
            String[] emails = new String[]{"a@leetcode.com", "b@leetcode.com", "c@leetcode.com"};
            System.out.println("  Output  : " + _tcShow(_tcSol.numUniqueEmails(emails)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
