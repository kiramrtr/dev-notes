# [876. Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/)

## Approach

Imagine `a` and `b`. If `b` is twice fast as `a` then if `a` takes 10 steps to reach the end `b` can does the same in 5 steps and once `b` reaches end `a` will be at the middle.

Using this intuition with two-pointer (slow and fast) approach we can find the middle element.

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
