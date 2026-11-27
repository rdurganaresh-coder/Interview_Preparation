package com.leetcode.bit_manipulation_math;

class Solution3280 {
    public String convertDateToBinary(String date) {
        List<String> ans = new ArrayList<>();
        for (var s : date.split("-")) {
            int x = Integer.parseInt(s);
            ans.add(Integer.toBinaryString(x));
        }
        return String.join("-", ans);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3280 _tcSol = new Solution3280();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "date = \"2080-02-29\"");
        try {
            String date = "2080-02-29";
            System.out.println("  Output  : " + _tcShow(_tcSol.convertDateToBinary(date)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"100000100000-10-11101\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "date = \"1900-01-01\"");
        try {
            String date = "1900-01-01";
            System.out.println("  Output  : " + _tcShow(_tcSol.convertDateToBinary(date)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"11101101100-1-1\"");
        System.out.println();
    }
}
