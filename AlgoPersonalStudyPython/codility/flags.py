from math import sqrt


def solution(A):
    if len(A) <= 2:
        return 0
    elif len(A) == 3:
        if A[0] < A[1] and A[1] > A[2]:
            return 1
        else:
            return 0

    peek_idx_list = []

    for idx in range(1, len(A) - 1):
        last_high = A[idx - 1]
        now_high = A[idx]
        next_high = A[idx + 1]
        if last_high < now_high and now_high > next_high:
            peek_idx_list.append(idx)

    peek_count = len(peek_idx_list)
    if peek_count == 0:
        return 0

    k = int(sqrt(len(A))) + 1
    while k > 0:
        last_peek = peek_idx_list[0]
        count = 1
        for i in range(1, peek_count):
            if peek_idx_list[i] - last_peek >= k:
                count += 1
                last_peek = peek_idx_list[i]
            if count == k:
                return k

        k -= 1
    return k


if __name__ == "__main__":
    param = [1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2]
    answer = solution(param)
    print(f"Answer : {answer}")
    assert answer == 3
