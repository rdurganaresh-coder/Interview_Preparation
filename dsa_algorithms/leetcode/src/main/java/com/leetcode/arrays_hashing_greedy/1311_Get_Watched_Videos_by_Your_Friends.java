package com.leetcode.arrays_hashing_greedy;

class Solution1311 {
    public List<String> watchedVideosByFriends(
        List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(id);
        int n = friends.length;
        boolean[] vis = new boolean[n];
        vis[id] = true;
        while (level-- > 0) {
            for (int k = q.size(); k > 0; --k) {
                int i = q.poll();
                for (int j : friends[i]) {
                    if (!vis[j]) {
                        vis[j] = true;
                        q.offer(j);
                    }
                }
            }
        }
        Map<String, Integer> cnt = new HashMap<>();
        for (int i : q) {
            for (var v : watchedVideos.get(i)) {
                cnt.merge(v, 1, Integer::sum);
            }
        }
        List<String> ans = new ArrayList<>(cnt.keySet());
        ans.sort((a, b) -> {
            int x = cnt.get(a), y = cnt.get(b);
            return x == y ? a.compareTo(b) : Integer.compare(x, y);
        });
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
        Solution1311 _tcSol = new Solution1311();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "watchedVideos = [[\"A\",\"B\"],[\"C\"],[\"B\",\"C\"],[\"D\"]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 1");
        try {
            List<List<String>> watchedVideos = _tcL(_tcL("A", "B"), _tcL("C"), _tcL("B", "C"), _tcL("D"));
            int[][] friends = new int[][]{new int[]{1, 2}, new int[]{0, 3}, new int[]{0, 3}, new int[]{1, 2}};
            int id = 0;
            int level = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.watchedVideosByFriends(watchedVideos, friends, id, level)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"B\",\"C\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "watchedVideos = [[\"A\",\"B\"],[\"C\"],[\"B\",\"C\"],[\"D\"]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 2");
        try {
            List<List<String>> watchedVideos = _tcL(_tcL("A", "B"), _tcL("C"), _tcL("B", "C"), _tcL("D"));
            int[][] friends = new int[][]{new int[]{1, 2}, new int[]{0, 3}, new int[]{0, 3}, new int[]{1, 2}};
            int id = 0;
            int level = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.watchedVideosByFriends(watchedVideos, friends, id, level)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"D\"]");
        System.out.println();
    }
}
