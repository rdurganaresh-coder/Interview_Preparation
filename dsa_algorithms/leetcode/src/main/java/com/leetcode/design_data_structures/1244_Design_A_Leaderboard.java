package com.leetcode.design_data_structures;

class Leaderboard1244 {
    private Map<Integer, Integer> d = new HashMap<>();
    private TreeMap<Integer, Integer> rank = new TreeMap<>((a, b) -> b - a);

    public Leaderboard1244() {
    }

    public void addScore(int playerId, int score) {
        d.merge(playerId, score, Integer::sum);
        int newScore = d.get(playerId);
        if (newScore != score) {
            rank.merge(newScore - score, -1, Integer::sum);
        }
        rank.merge(newScore, 1, Integer::sum);
    }

    public int top(int K) {
        int ans = 0;
        for (var e : rank.entrySet()) {
            int score = e.getKey(), cnt = e.getValue();
            cnt = Math.min(cnt, K);
            ans += score * cnt;
            K -= cnt;
            if (K == 0) {
                break;
            }
        }
        return ans;
    }

    public void reset(int playerId) {
        int score = d.remove(playerId);
        if (rank.merge(score, -1, Integer::sum) == 0) {
            rank.remove(score);
        }
    }
}

/**
 * Your Leaderboard1244 object will be instantiated and called as such:
 * Leaderboard1244 obj = new Leaderboard1244();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */