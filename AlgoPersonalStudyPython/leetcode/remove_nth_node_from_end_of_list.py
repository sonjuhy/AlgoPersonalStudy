# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        queue_list: list[ListNode] = []
        dummy: ListNode = head
        while dummy is not None:
            if len(queue_list) > n:
                queue_list.pop(0)
            queue_list.append(dummy)
            dummy = dummy.next

        if len(queue_list) == n:
            head = head.next
            return head
        remove_node = queue_list[0].next
        if remove_node is None:
            return None
        queue_list[0].next = remove_node.next
        return head
