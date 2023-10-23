# 141. Linked List Cycle

```{code-block} java
:linenos:
:dedent: 2

  public boolean hasCycle(ListNode head) {
    ListNode slowPointer = head;
    ListNode fastPointer = head;

    while (fastPointer != null && fastPointer.next != null) {
      slowPointer = slowPointer.next;
      fastPointer = fastPointer.next.next;

      if (slowPointer == fastPointer) {
        return true;
      }
    }

    return false;
  }
```
