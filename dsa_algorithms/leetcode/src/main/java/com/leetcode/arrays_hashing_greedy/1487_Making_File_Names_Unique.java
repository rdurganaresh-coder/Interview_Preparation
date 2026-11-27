package com.leetcode.arrays_hashing_greedy;

class Solution1487 {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> d = new HashMap<>();
        for (int i = 0; i < names.length; ++i) {
            if (d.containsKey(names[i])) {
                int k = d.get(names[i]);
                while (d.containsKey(names[i] + "(" + k + ")")) {
                    ++k;
                }
                d.put(names[i], k);
                names[i] += "(" + k + ")";
            }
            d.put(names[i], 1);
        }
        return names;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1487 _tcSol = new Solution1487();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "names = [\"pes\",\"fifa\",\"gta\",\"pes(2019)\"]");
        try {
            String[] names = new String[]{"pes", "fifa", "gta", "pes(2019)"};
            System.out.println("  Output  : " + _tcShow(_tcSol.getFolderNames(names)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"pes\",\"fifa\",\"gta\",\"pes(2019)\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "names = [\"gta\",\"gta(1)\",\"gta\",\"avalon\"]");
        try {
            String[] names = new String[]{"gta", "gta(1)", "gta", "avalon"};
            System.out.println("  Output  : " + _tcShow(_tcSol.getFolderNames(names)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"gta\",\"gta(1)\",\"gta(2)\",\"avalon\"]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "names = [\"onepiece\",\"onepiece(1)\",\"onepiece(2)\",\"onepiece(3)\",\"onepiece\"]");
        try {
            String[] names = new String[]{"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece"};
            System.out.println("  Output  : " + _tcShow(_tcSol.getFolderNames(names)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"onepiece\",\"onepiece(1)\",\"onepiece(2)\",\"onepiece(3)\",\"onepiece(4)\"]");
        System.out.println();
    }
}