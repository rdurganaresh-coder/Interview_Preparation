package com.leetcode.arrays_hashing_greedy;

class Solution1410 {
    public String entityParser(String text) {
        Map<String, String> d = new HashMap<>();
        d.put("&quot;", "\"");
        d.put("&apos;", "'");
        d.put("&amp;", "&");
        d.put("&gt;", ">");
        d.put("&lt;", "<");
        d.put("&frasl;", "/");
        StringBuilder ans = new StringBuilder();
        int i = 0;
        int n = text.length();
        while (i < n) {
            boolean found = false;
            for (int l = 1; l < 8; ++l) {
                int j = i + l;
                if (j <= n) {
                    String t = text.substring(i, j);
                    if (d.containsKey(t)) {
                        ans.append(d.get(t));
                        i = j;
                        found = true;
                        break;
                    }
                }
            }
            if (!found) {
                ans.append(text.charAt(i++));
            }
        }
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1410 _tcSol = new Solution1410();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "text = \"&amp; is an HTML entity but &ambassador; is not.\"");
        try {
            String text = "&amp; is an HTML entity but &ambassador; is not.";
            System.out.println("  Output  : " + _tcShow(_tcSol.entityParser(text)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"& is an HTML entity but &ambassador; is not.\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "text = \"and I quote: &quot;...&quot;\"");
        try {
            String text = "and I quote: &quot;...&quot;";
            System.out.println("  Output  : " + _tcShow(_tcSol.entityParser(text)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"and I quote: \\\"...\\\"\"");
        System.out.println();
    }
}