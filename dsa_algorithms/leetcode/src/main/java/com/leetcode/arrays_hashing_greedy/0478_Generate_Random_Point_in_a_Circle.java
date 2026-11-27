package com.leetcode.arrays_hashing_greedy;

class Solution0478 {
    double r, cx, cy;

    public Solution0478(double radius, double x_center, double y_center) {
        r = radius;
        cx = x_center;
        cy = y_center;
    }

    public double[] randPoint() {
        double d = r * Math.sqrt(Math.random());
        double a = 2 * Math.PI * Math.random();
        return new double[] {cx + d * Math.cos(a), cy + d * Math.sin(a)};
    }
}

/**
 * Your Solution0478 object will be instantiated and called as such:
 * Solution0478 obj = new Solution0478(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
