class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def make_datas() -> list[ListNode]:
    inputs = [[[1, 2, 3], [1, 2, 4]]]
    input_nodes: ListNode | None = None
    root_node: ListNode | None = None
    for data in inputs:
        if input_nodes == None:
            input_nodes = ListNode(data)
            root_node = input_nodes
        else:
            input_nodes.next = ListNode(data)
            input_nodes = input_nodes.next
    input_nodes = root_node

    outputs = [[1, 1, 2, 2, 3, 4]]
    output_nodes: ListNode | None = None
    root_node = None
    for data in outputs:
        if output_nodes == None:
            output_nodes = ListNode(data)
            root_node = output_nodes
        else:
            output_nodes.next = ListNode(data)
            output_nodes = output_nodes.next

    return input_nodes, output_nodes


def solution(list1: ListNode | None, list2: ListNode | None):
    answer: ListNode | None = None
    if list1 is None:
        return list2
    elif list2 is None:
        return list1

    if list1.val < list2.val:
        answer = list1
        list1 = list1.next
    else:
        answer = list2
        list2 = list2.next
    root_node: ListNode | None = answer
    while True:
        if list1 is None and list2 is None:
            break
        if list1 is None:
            answer.next = list2
            list2 = list2.next
        elif list2 is None:
            answer.next = list1
            list1 = list1.next
        else:
            if list1.val < list2.val:
                answer.next = list1
                list1 = list1.next
            else:
                answer.next = list2
                list2 = list2.next
        answer = answer.next
    return root_node


if __name__ == "__main__":
    INPUTS, OUTPUTS = make_datas()
    result = solution(INPUTS[0], INPUTS[1])
    assert OUTPUTS == INPUTS
