package sujata.algo;

import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(""+(4 == findKthLargest(nums, k)));
        k = 5;
        System.out.println(""+(3 == findKthLargest(nums, k)));
    }


    //    /**
//     * Time complexity: O(n log k)
//     * Space complexity: O(k)
//     */
     private static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek() !=null ? pq.peek() : -1;
    }
}
