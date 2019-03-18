package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by abaisa on 2019/3/18.
 */
public class P480 {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

    public double[] medianSlidingWindow(int[] nums, int k) {
        // init priority queue
        for (int i = 0; i < k; i++) {
            push(nums[i]);
        }

        //
        int resLen = nums.length - k + 1;
        double[] res = new double[resLen];
        res[0] = this.getMedium();
        for (int i = 1; i < resLen; i++) {
            this.remove(nums[i - 1]);
            this.push(nums[i + k - 1]);
            res[i] = getMedium();
        }
        return res;
    }

    private void push(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    private void remove(int num) {
        if (num > maxHeap.peek()) minHeap.remove(num);
        else maxHeap.remove(num);

        while (maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    private double getMedium() {
        if (minHeap.size() == maxHeap.size())
            return (double)(((double)minHeap.peek() + (double)maxHeap.peek()) / 2);
        return maxHeap.peek();
    }
}
