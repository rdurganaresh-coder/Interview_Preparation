package com.leetcode.arrays_hashing_greedy;

class Solution1826 {
    public int badSensor(int[] sensor1, int[] sensor2) {
        int i = 0;
        int n = sensor1.length;
        for (; i < n - 1 && sensor1[i] == sensor2[i]; ++i) {
        }
        for (; i < n - 1; ++i) {
            if (sensor1[i + 1] != sensor2[i]) {
                return 1;
            }
            if (sensor1[i] != sensor2[i + 1]) {
                return 2;
            }
        }
        return -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1826 _tcSol = new Solution1826();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "sensor1 = [2,3,4,5], sensor2 = [2,1,3,4]");
        try {
            int[] sensor1 = new int[]{2, 3, 4, 5};
            int[] sensor2 = new int[]{2, 1, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.badSensor(sensor1, sensor2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "sensor1 = [2,2,2,2,2], sensor2 = [2,2,2,2,5]");
        try {
            int[] sensor1 = new int[]{2, 2, 2, 2, 2};
            int[] sensor2 = new int[]{2, 2, 2, 2, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.badSensor(sensor1, sensor2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "sensor1 = [2,3,2,2,3,2], sensor2 = [2,3,2,3,2,7]");
        try {
            int[] sensor1 = new int[]{2, 3, 2, 2, 3, 2};
            int[] sensor2 = new int[]{2, 3, 2, 3, 2, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.badSensor(sensor1, sensor2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}