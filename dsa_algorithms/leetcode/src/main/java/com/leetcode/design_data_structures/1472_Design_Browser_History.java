package com.leetcode.design_data_structures;

class BrowserHistory1472 {
    private Deque<String> stk1 = new ArrayDeque<>();
    private Deque<String> stk2 = new ArrayDeque<>();

    public BrowserHistory1472(String homepage) {
        visit(homepage);
    }

    public void visit(String url) {
        stk1.push(url);
        stk2.clear();
    }

    public String back(int steps) {
        for (; steps > 0 && stk1.size() > 1; --steps) {
            stk2.push(stk1.pop());
        }
        return stk1.peek();
    }

    public String forward(int steps) {
        for (; steps > 0 && !stk2.isEmpty(); --steps) {
            stk1.push(stk2.pop());
        }
        return stk1.peek();
    }
}

/**
 * Your BrowserHistory1472 object will be instantiated and called as such:
 * BrowserHistory1472 obj = new BrowserHistory1472(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */