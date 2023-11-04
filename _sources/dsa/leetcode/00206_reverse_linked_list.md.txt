# 206. Reverse Linked List

```{code-block} java
:linenos:

public ListNode reverseList(ListNode head) {
  ListNode newHead = null;

  while (head != null) {
    ListNode next = head.next;
    head.next = newHead;
    newHead = head;
    head = next;
  }

  return newHead;
}
```
