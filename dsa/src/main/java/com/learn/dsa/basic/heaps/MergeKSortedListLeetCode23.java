package com.learn.dsa.basic.heaps;
/**
 * 17th July 2025
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted linked list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 

Constraints:

k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.
 */

import java.util.*;


public class MergeKSortedListLeetCode23 {

    // Definition for singly-linked list.
    static class ListNode { // Made static for access from static main
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        // Helper method to print the linked list
        public void printList() {
            ListNode current = this;
            while (current != null) {
                System.out.print(current.val);
                if (current.next != null) {
                    System.out.print(" -> ");
                }
                current = current.next;
            }
            System.out.println();
        }
    }

    static class Solution { // Made static for access from static main
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }

            // Create a min-priority queue
            PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

            // Add the head of each list to the priority queue
            for (ListNode list : lists) {
                if (list != null) {
                    pq.add(list);
                }
            }

            ListNode dummyHead = new ListNode(0); // Dummy node to simplify building the new list
            ListNode current = dummyHead;

            // Build the merged list
            while (!pq.isEmpty()) {
                ListNode smallestNode = pq.poll();
                current.next = smallestNode;
                current = current.next;

                if (smallestNode.next != null) {
                    pq.add(smallestNode.next);
                }
            }

            return dummyHead.next;
        }
    }

    public static void main(String arg[]) {
        Solution sol = new Solution(); // Create an instance of the Solution class

        // Test Case 1: Basic example
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));
        ListNode[] lists1 = {l1, l2, l3};
        System.out.print("Input lists 1: ");
        for (ListNode list : lists1) {
            if (list != null) {
                list.printList();
            } else {
                System.out.println("null");
            }
        }
        ListNode mergedList1 = sol.mergeKLists(lists1);
        System.out.print("Merged list 1: ");
        if (mergedList1 != null) {
            mergedList1.printList();
        } else {
            System.out.println("null");
        }
        System.out.println();

        // Test Case 2: Empty lists and null pointers
        ListNode l4 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode l5 = null; // An empty list
        ListNode l6 = new ListNode(4);
        ListNode[] lists2 = {l4, l5, l6};
        System.out.print("Input lists 2: ");
        for (ListNode list : lists2) {
            if (list != null) {
                list.printList();
            } else {
                System.out.println("null");
            }
        }
        ListNode mergedList2 = sol.mergeKLists(lists2);
        System.out.print("Merged list 2: ");
        if (mergedList2 != null) {
            mergedList2.printList();
        } else {
            System.out.println("null");
        }
        System.out.println();

        // Test Case 3: All empty lists
        ListNode[] lists3 = {null, null, null};
        System.out.print("Input lists 3: ");
        for (ListNode list : lists3) {
            if (list != null) {
                list.printList();
            } else {
                System.out.println("null");
            }
        }
        ListNode mergedList3 = sol.mergeKLists(lists3);
        System.out.print("Merged list 3: ");
        if (mergedList3 != null) {
            mergedList3.printList();
        } else {
            System.out.println("null");
        }
        System.out.println();

        // Test Case 4: Single list
        ListNode l7 = new ListNode(10, new ListNode(20, new ListNode(30)));
        ListNode[] lists4 = {l7};
        System.out.print("Input lists 4: ");
        for (ListNode list : lists4) {
            if (list != null) {
                list.printList();
            } else {
                System.out.println("null");
            }
        }
        ListNode mergedList4 = sol.mergeKLists(lists4);
        System.out.print("Merged list 4: ");
        if (mergedList4 != null) {
            mergedList4.printList();
        } else {
            System.out.println("null");
        }
        System.out.println();
    }
}
