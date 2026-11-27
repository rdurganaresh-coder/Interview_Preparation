package com.leetcode.arrays_hashing_greedy;

class Solution1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int i = ruleKey.charAt(0) == 't' ? 0 : (ruleKey.charAt(0) == 'c' ? 1 : 2);
        int ans = 0;
        for (var v : items) {
            if (v.get(i).equals(ruleValue)) {
                ++ans;
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution1773 _tcSol = new Solution1773();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "items = [[\"phone\",\"blue\",\"pixel\"],[\"computer\",\"silver\",\"lenovo\"],[\"phone\",\"gold\",\"iphone\"]], ruleKey = \"color\", ruleValue = \"silver\"");
        try {
            List<List<String>> items = _tcL(_tcL("phone", "blue", "pixel"), _tcL("computer", "silver", "lenovo"), _tcL("phone", "gold", "iphone"));
            String ruleKey = "color";
            String ruleValue = "silver";
            System.out.println("  Output  : " + _tcShow(_tcSol.countMatches(items, ruleKey, ruleValue)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "items = [[\"phone\",\"blue\",\"pixel\"],[\"computer\",\"silver\",\"phone\"],[\"phone\",\"gold\",\"iphone\"]], ruleKey = \"type\", ruleValue = \"phone\"");
        try {
            List<List<String>> items = _tcL(_tcL("phone", "blue", "pixel"), _tcL("computer", "silver", "phone"), _tcL("phone", "gold", "iphone"));
            String ruleKey = "type";
            String ruleValue = "phone";
            System.out.println("  Output  : " + _tcShow(_tcSol.countMatches(items, ruleKey, ruleValue)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}