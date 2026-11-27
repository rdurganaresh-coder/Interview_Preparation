package com.leetcode.arrays_hashing_greedy;

class Solution0838 {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        Deque<Integer> q = new ArrayDeque<>();
        int[] time = new int[n];
        Arrays.fill(time, -1);
        List<Character>[] force = new List[n];
        for (int i = 0; i < n; ++i) {
            force[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; ++i) {
            char f = dominoes.charAt(i);
            if (f != '.') {
                q.offer(i);
                time[i] = 0;
                force[i].add(f);
            }
        }
        char[] ans = new char[n];
        Arrays.fill(ans, '.');
        while (!q.isEmpty()) {
            int i = q.poll();
            if (force[i].size() == 1) {
                ans[i] = force[i].get(0);
                char f = ans[i];
                int j = f == 'L' ? i - 1 : i + 1;
                if (j >= 0 && j < n) {
                    int t = time[i];
                    if (time[j] == -1) {
                        q.offer(j);
                        time[j] = t + 1;
                        force[j].add(f);
                    } else if (time[j] == t + 1) {
                        force[j].add(f);
                    }
                }
            }
        }
        return new String(ans);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0838 _tcSol = new Solution0838();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "dominoes = \"RR.L\"");
        try {
            String dominoes = "RR.L";
            System.out.println("  Output  : " + _tcShow(_tcSol.pushDominoes(dominoes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"RR.L\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "dominoes = \".L.R...LR..L..\"");
        try {
            String dominoes = ".L.R...LR..L..";
            System.out.println("  Output  : " + _tcShow(_tcSol.pushDominoes(dominoes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"LL.RR.LLRRLL..\"");
        System.out.println();
    }
}