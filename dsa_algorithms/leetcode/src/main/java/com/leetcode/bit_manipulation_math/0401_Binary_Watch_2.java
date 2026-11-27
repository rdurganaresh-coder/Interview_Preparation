package com.leetcode.bit_manipulation_math;

class Solution0401_2 {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 1 << 10; ++i) {
            int h = i >> 6, m = i & 0b111111;
            if (h < 12 && m < 60 && Integer.bitCount(i) == turnedOn) {
                ans.add(String.format("%d:%02d", h, m));
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
        Solution0401_2 _tcSol = new Solution0401_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "turnedOn = 1");
        try {
            int turnedOn = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.readBinaryWatch(turnedOn)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"0:01\",\"0:02\",\"0:04\",\"0:08\",\"0:16\",\"0:32\",\"1:00\",\"2:00\",\"4:00\",\"8:00\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "turnedOn = 9");
        try {
            int turnedOn = 9;
            System.out.println("  Output  : " + _tcShow(_tcSol.readBinaryWatch(turnedOn)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}