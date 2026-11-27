package com.leetcode.sliding_window_two_pointers;

class Solution3556 {
    public long sumOfLargestPrimes(String s) {
        Set<Long> st = new HashSet<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            long x = 0;
            for (int j = i; j < n; j++) {
                x = x * 10 + (s.charAt(j) - '0');
                if (is_prime(x)) {
                    st.add(x);
                }
            }
        }

        List<Long> sorted = new ArrayList<>(st);
        Collections.sort(sorted);

        long ans = 0;
        int start = Math.max(0, sorted.size() - 3);
        for (int idx = start; idx < sorted.size(); idx++) {
            ans += sorted.get(idx);
        }
        return ans;
    }

    private boolean is_prime(long x) {
        if (x < 2) return false;
        for (long i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3556 _tcSol = new Solution3556();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"12234\"");
        try {
            String s = "12234";
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOfLargestPrimes(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1469");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"111\"");
        try {
            String s = "111";
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOfLargestPrimes(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();
    }
}