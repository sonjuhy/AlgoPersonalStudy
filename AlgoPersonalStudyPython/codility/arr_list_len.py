def solution(A):
    # Implement your solution here
    answer = 0
    idx = 0
    while True:
        answer += 1
        next_idx = A[idx]
        if next_idx < 0 or next_idx >= len(A):
            break
        idx = next_idx

    return answer
