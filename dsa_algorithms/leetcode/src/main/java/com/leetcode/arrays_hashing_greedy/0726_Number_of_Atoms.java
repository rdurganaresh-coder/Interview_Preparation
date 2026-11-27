package com.leetcode.arrays_hashing_greedy;

class Solution0726 {
    public String countOfAtoms(String formula) {
        Map<String, Integer> map = new HashMap<>();
        int[] stack = new int[1000];
        int top = 0, multiplier = 1, freq = 0;
        char[] c = formula.toCharArray();
        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] >= 'a' && c[i] <= 'z') {
                int end = i--;
                while (i >= 0 && c[i] >= 'a' && c[i] <= 'z') i--;
                String key = new String(c, i, end - i + 1);
                map.put(key, map.getOrDefault(key, 0) + Math.max(freq, 1) * multiplier);
                freq = 0;
            } else if (c[i] >= 'A' && c[i] <= 'Z') {
                String key = new String(c, i, 1);
                map.put(key, map.getOrDefault(key, 0) + Math.max(freq, 1) * multiplier);
                freq = 0;
            } else if (c[i] >= '0' && c[i] <= '9') {
                freq = c[i] - '0';
                int p = 10;
                while (i - 1 >= 0 && c[i - 1] >= '0' && c[i - 1] <= '9') {
                    freq += p * (c[--i] - '0');
                    p *= 10;
                }
            } else if (c[i] == ')') {
                stack[top++] = multiplier;
                multiplier *= Math.max(freq, 1);
                freq = 0;
            } else {
                multiplier = stack[--top];
            }
        }
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            sb.append(key);
            int f = map.get(key);
            if (f > 1) sb.append(f);
        }
        return sb.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0726 _tcSol = new Solution0726();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "formula = \"H2O\"");
        try {
            String formula = "H2O";
            System.out.println("  Output  : " + _tcShow(_tcSol.countOfAtoms(formula)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"H2O\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "formula = \"Mg(OH)2\"");
        try {
            String formula = "Mg(OH)2";
            System.out.println("  Output  : " + _tcShow(_tcSol.countOfAtoms(formula)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"H2MgO2\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "formula = \"K4(ON(SO3)2)2\"");
        try {
            String formula = "K4(ON(SO3)2)2";
            System.out.println("  Output  : " + _tcShow(_tcSol.countOfAtoms(formula)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"K4N2O14S4\"");
        System.out.println();
    }
}
