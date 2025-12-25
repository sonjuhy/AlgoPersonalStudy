def solution(A):
    if len(A) < 3:
        return 0

    peek_idx_list = []

    for idx in range(1, len(A) - 1):
        front_data = A[idx - 1]
        now_data = A[idx]
        back_data = A[idx + 1]
        if front_data < now_data and now_data > back_data:
            peek_idx_list.append(idx)

    len_a = len(A)
    prime_list = []

    for i in range(1, int(len_a**0.5) + 1):
        if len_a % i == 0:
            prime_list.append(i)
            if i * i != len_a:
                prime_list.append(int(len_a / i))
    prime_list.sort(reverse=True)
    answer = 0
    for prime in prime_list:
        if prime > len(peek_idx_list):
            continue
        block_set = set()
        for peek in peek_idx_list:
            block_set.add(int(peek // (len_a / prime)))

        if len(block_set) == prime:
            answer = prime
            break
    return answer


if __name__ == "__main__":
    param = [1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2]
    answer = solution(param)
    print(f"Answer : {answer}")
    assert answer == 3
