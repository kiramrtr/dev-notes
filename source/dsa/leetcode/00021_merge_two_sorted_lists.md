# [21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)

## Code

```{code-block} java
:linenos:
:dedent: 2

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummyHead = new ListNode();
    ListNode currentNode = dummyHead;

    while (list1 != null && list2 != null) {
      if (list1.val <= list2.val) {
        currentNode.next = list1;
        list1 = list1.next;
      } else {
        currentNode.next = list2;
        list2 = list2.next;
      }
      currentNode = currentNode.next;
    }

    if (list1 != null) {
      currentNode.next = list1;
    } else {
      currentNode.next = list2;
    }

    return dummyHead.next;
  }
```

| Time Complexity  | Space Complexity |
| :--------------: | :--------------: |
| $\mathcal{O}(n)$ | $\mathcal{O}(1)$ |
