package com.leetcode.arrays_hashing_greedy;

class Solution2129 {
    public String capitalizeTitle(String title) {
        List<String> ans = new ArrayList<>();
        for (String s : title.split(" ")) {
            if (s.length() < 3) {
                ans.add(s.toLowerCase());
            } else {
                ans.add(s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase());
            }
        }
        return String.join(" ", ans);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2129 _tcSol = new Solution2129();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "title = \"capiTalIze tHe titLe\"");
        try {
            String title = "capiTalIze tHe titLe";
            System.out.println("  Output  : " + _tcShow(_tcSol.capitalizeTitle(title)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"Capitalize The Title\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "title = \"First leTTeR of EACH Word\"");
        try {
            String title = "First leTTeR of EACH Word";
            System.out.println("  Output  : " + _tcShow(_tcSol.capitalizeTitle(title)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"First Letter of Each Word\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "title = \"i lOve leetcode\"");
        try {
            String title = "i lOve leetcode";
            System.out.println("  Output  : " + _tcShow(_tcSol.capitalizeTitle(title)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"i Love Leetcode\"");
        System.out.println();
    }
}