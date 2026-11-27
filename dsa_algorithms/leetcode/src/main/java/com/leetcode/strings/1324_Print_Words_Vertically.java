package com.leetcode.strings;

class Solution1324 {
    public List<String> printVertically(String s) {
        String[] words = s.split(" ");
        int n = 0;
        for (var w : words) {
            n = Math.max(n, w.length());
        }
        List<String> ans = new ArrayList<>();
        for (int j = 0; j < n; ++j) {
            StringBuilder t = new StringBuilder();
            for (var w : words) {
                t.append(j < w.length() ? w.charAt(j) : ' ');
            }
            while (t.length() > 0 && t.charAt(t.length() - 1) == ' ') {
                t.deleteCharAt(t.length() - 1);
            }
            ans.add(t.toString());
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1324 _tcSol = new Solution1324();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"HOW ARE YOU\"");
        try {
            String s = "HOW ARE YOU";
            System.out.println("  Output  : " + _tcShow(_tcSol.printVertically(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"HAY\",\"ORO\",\"WEU\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"TO BE OR NOT TO BE\"");
        try {
            String s = "TO BE OR NOT TO BE";
            System.out.println("  Output  : " + _tcShow(_tcSol.printVertically(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"TBONTB\",\"OEROOE\",\" T\"]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"CONTEST IS COMING\"");
        try {
            String s = "CONTEST IS COMING";
            System.out.println("  Output  : " + _tcShow(_tcSol.printVertically(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"CIC\",\"OSO\",\"N M\",\"T I\",\"E N\",\"S G\",\"T\"]");
        System.out.println();
    }
}