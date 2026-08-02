# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def addTwoNumbers(
        self, l1: Optional[ListNode], l2: Optional[ListNode]
    ) -> Optional[ListNode]:
        answer: Optional[ListNode] = ListNode(0)
        l1_str: str = ""
        while l1 is not None:
            l1_str += str(l1.val)
            l1 = l1.next

        l2_str: str = ""
        while l2 is not None:
            l2_str += str(l2.val)
            l2 = l2.next

        l1_num: int = int(l1_str[::-1])
        l2_num: int = int(l2_str[::-1])
        num_list: list[int] = list(map(int, str(l1_num + l2_num)))

        dummay = answer
        for num in num_list[::-1]:
            dummay.next = ListNode(num)
            dummay = dummay.next
        return answer.next
