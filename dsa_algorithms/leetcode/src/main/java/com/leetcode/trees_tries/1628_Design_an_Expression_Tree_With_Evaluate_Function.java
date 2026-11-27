package com.leetcode.trees_tries;

/**
 * This is the interface for the expression tree Node1628.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node1628 {
    public abstract int evaluate();
    // define your fields here
    protected String val;
    protected Node1628 left;
    protected Node1628 right;
};

class MyNode1628 extends Node1628 {
    public MyNode1628(String val) {
        this.val = val;
    }

    public int evaluate() {
        if (isNumeric()) {
            return Integer.parseInt(val);
        }
        int leftVal = left.evaluate();
        int rightVal = right.evaluate();
        if (Objects.equals(val, "+")) {
            return leftVal + rightVal;
        }
        if (Objects.equals(val, "-")) {
            return leftVal - rightVal;
        }
        if (Objects.equals(val, "*")) {
            return leftVal * rightVal;
        }
        if (Objects.equals(val, "/")) {
            return leftVal / rightVal;
        }
        return 0;
    }

    public boolean isNumeric() {
        for (char c : val.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}

/**
 * This is the TreeBuilder1628 class.
 * You can treat it as the driver code that takes the postinfix input
 * and returns the expression tree represnting it as a Node1628.
 */

class TreeBuilder1628 {
    Node1628 buildTree(String[] postfix) {
        Deque<MyNode1628> stk = new ArrayDeque<>();
        for (String s : postfix) {
            MyNode1628 node = new MyNode1628(s);
            if (!node.isNumeric()) {
                node.right = stk.pop();
                node.left = stk.pop();
            }
            stk.push(node);
        }
        return stk.peek();
    }
};

/**
 * Your TreeBuilder1628 object will be instantiated and called as such:
 * TreeBuilder1628 obj = new TreeBuilder1628();
 * Node1628 expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */