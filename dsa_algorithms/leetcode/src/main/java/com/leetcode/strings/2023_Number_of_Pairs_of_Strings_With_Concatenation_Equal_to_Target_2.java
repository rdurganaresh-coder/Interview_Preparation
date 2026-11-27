package com.leetcode.strings;

class Solution2023_2 {
    public int numOfPairs(String[] nums, String target) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String x : nums) {
            cnt.merge(x, 1, Integer::sum);
        }
        int ans = 0;
        for (int i = 1; i < target.length(); ++i) {
            String a = target.substring(0, i);
            String b = target.substring(i);
            int x = cnt.getOrDefault(a, 0);
            int y = cnt.getOrDefault(b, 0);
            if (!a.equals(b)) {
                ans += x * y;
            } else {
                ans += x * (y - 1);
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
        Solution2023_2 _tcSol = new Solution2023_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [\"777\",\"7\",\"77\",\"77\"], target = \"7777\"");
        try {
            String[] nums = new String[]{"777", "7", "77", "77"};
            String target = "7777";
            System.out.println("  Output  : " + _tcShow(_tcSol.numOfPairs(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [\"123\",\"4\",\"12\",\"34\"], target = \"1234\"");
        try {
            String[] nums = new String[]{"123", "4", "12", "34"};
            String target = "1234";
            System.out.println("  Output  : " + _tcShow(_tcSol.numOfPairs(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [\"1\",\"1\",\"1\"], target = \"11\"");
        try {
            String[] nums = new String[]{"1", "1", "1"};
            String target = "11";
            System.out.println("  Output  : " + _tcShow(_tcSol.numOfPairs(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}