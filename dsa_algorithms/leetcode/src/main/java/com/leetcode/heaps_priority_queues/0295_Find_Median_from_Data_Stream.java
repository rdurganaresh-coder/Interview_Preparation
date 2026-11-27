package com.leetcode.heaps_priority_queues;

class MedianFinder0295 {
    private PriorityQueue<Integer> minQ = new PriorityQueue<>();
    private PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder0295() {
    }

    public void addNum(int num) {
        maxQ.offer(num);
        minQ.offer(maxQ.poll());
        if (minQ.size() - maxQ.size() > 1) {
            maxQ.offer(minQ.poll());
        }
    }

    public double findMedian() {
        return minQ.size() == maxQ.size() ? (minQ.peek() + maxQ.peek()) / 2.0 : minQ.peek();
    }
}

/**
 * Your MedianFinder0295 object will be instantiated and called as such:
 * MedianFinder0295 obj = new MedianFinder0295();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
