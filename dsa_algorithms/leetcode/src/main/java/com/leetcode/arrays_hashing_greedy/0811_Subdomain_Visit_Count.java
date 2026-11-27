package com.leetcode.arrays_hashing_greedy;

class Solution0811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String s : cpdomains) {
            int i = s.indexOf(" ");
            int v = Integer.parseInt(s.substring(0, i));
            for (; i < s.length(); ++i) {
                if (s.charAt(i) == ' ' || s.charAt(i) == '.') {
                    String t = s.substring(i + 1);
                    cnt.put(t, cnt.getOrDefault(t, 0) + v);
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for (var e : cnt.entrySet()) {
            ans.add(e.getValue() + " " + e.getKey());
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0811 _tcSol = new Solution0811();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "cpdomains = [\"9001 discuss.leetcode.com\"]");
        try {
            String[] cpdomains = new String[]{"9001 discuss.leetcode.com"};
            System.out.println("  Output  : " + _tcShow(_tcSol.subdomainVisits(cpdomains)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"9001 leetcode.com\",\"9001 discuss.leetcode.com\",\"9001 com\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "cpdomains = [\"900 google.mail.com\", \"50 yahoo.com\", \"1 intel.mail.com\", \"5 wiki.org\"]");
        try {
            String[] cpdomains = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
            System.out.println("  Output  : " + _tcShow(_tcSol.subdomainVisits(cpdomains)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"901 mail.com\",\"50 yahoo.com\",\"900 google.mail.com\",\"5 wiki.org\",\"5 org\",\"1 intel.mail.com\",\"951 com\"]");
        System.out.println();
    }
}