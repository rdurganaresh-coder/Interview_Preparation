package com.geeksforgeeks;

public class SecondLargest {
    public int getSecondLargest(int[] arr) {
        int first = -1, second = -1;
        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num < first) {
                second = num;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        SecondLargest solver = new SecondLargest();
        System.out.println(solver.getSecondLargest(new int[]{12, 35, 1, 10, 34, 1}));
    }
}
