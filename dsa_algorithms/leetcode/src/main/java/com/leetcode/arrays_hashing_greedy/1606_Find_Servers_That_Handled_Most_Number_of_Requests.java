package com.leetcode.arrays_hashing_greedy;

class Solution1606 {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] cnt = new int[k];
        PriorityQueue<int[]> busy = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        TreeSet<Integer> free = new TreeSet<>();
        for (int i = 0; i < k; ++i) {
            free.add(i);
        }
        for (int i = 0; i < arrival.length; ++i) {
            int start = arrival[i];
            int end = start + load[i];
            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                free.add(busy.poll()[1]);
            }
            if (free.isEmpty()) {
                continue;
            }
            Integer server = free.ceiling(i % k);
            if (server == null) {
                server = free.first();
            }
            ++cnt[server];
            busy.offer(new int[] {end, server});
            free.remove(server);
        }
        int mx = 0;
        for (int v : cnt) {
            mx = Math.max(mx, v);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            if (cnt[i] == mx) {
                ans.add(i);
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
        Solution1606 _tcSol = new Solution1606();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "k = 3, arrival = [1,2,3,4,5], load = [5,2,3,3,3]");
        try {
            int k = 3;
            int[] arrival = new int[]{1, 2, 3, 4, 5};
            int[] load = new int[]{5, 2, 3, 3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.busiestServers(k, arrival, load)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "k = 3, arrival = [1,2,3,4], load = [1,2,1,2]");
        try {
            int k = 3;
            int[] arrival = new int[]{1, 2, 3, 4};
            int[] load = new int[]{1, 2, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.busiestServers(k, arrival, load)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "k = 3, arrival = [1,2,3], load = [10,12,11]");
        try {
            int k = 3;
            int[] arrival = new int[]{1, 2, 3};
            int[] load = new int[]{10, 12, 11};
            System.out.println("  Output  : " + _tcShow(_tcSol.busiestServers(k, arrival, load)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1,2]");
        System.out.println();
    }
}