def solution(A):
    # Implement your solution here
    a_set = set()
    for a in A:
        a_set.add(abs(a))

    return len(a_set)
