# [876. Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/)

## Approach

Imagine two elements, **a** and **b**. If **b** moves twice as fast as **a**, then when **a** takes 10 steps to reach the end, **b** can cover the same distance in just 5 steps. Once **b** reaches the end, **a** will be positioned at the middle.

By applying this intuition and utilizing a two-pointer (slow and fast) approach, we can efficiently determine the middle element.

## Code

```{code-block} java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public ListNode middleNode(ListNode head) {
    ListNode slow = head, fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }
}
```

| Time Complexity  | Space Complexity |
| :--------------: | :--------------: |
| $\mathcal{O}(n)$ | $\mathcal{O}(1)$ |
