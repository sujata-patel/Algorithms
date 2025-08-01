package sujata.algo;

import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        assert(4 == findKthLargest(nums, k));
        k = 5;
        assert(3 == findKthLargest(nums, k));
    }

    /**
     * Time complexity: O(n log k)
     * Space complexity: O(k)
     */
    private static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek() != null ? minHeap.peek():-1;
    }
}
