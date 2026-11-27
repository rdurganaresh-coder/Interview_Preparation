package com.leetcode.arrays_hashing_greedy;

class StockSpanner0901 {
    private Deque<int[]> stk = new ArrayDeque<>();

    public StockSpanner0901() {
    }

    public int next(int price) {
        int cnt = 1;
        while (!stk.isEmpty() && stk.peek()[0] <= price) {
            cnt += stk.pop()[1];
        }
        stk.push(new int[] {price, cnt});
        return cnt;
    }
}

/**
 * Your StockSpanner0901 object will be instantiated and called as such:
 * StockSpanner0901 obj = new StockSpanner0901();
 * int param_1 = obj.next(price);
 */