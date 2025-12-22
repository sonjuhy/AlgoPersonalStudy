def solution(N):
    if N == 1:
        return 1

    prime_candidate = 2
    prime_list = []
    prime_idx_list = []

    while prime_candidate * prime_candidate <= N:

        if N % prime_candidate == 0:
            count = 0
            while N % prime_candidate == 0:
                count += 1
                prime_list.append(prime_candidate)
                N /= prime_candidate
            prime_idx_list.append(count)
        prime_candidate += 1
    if N > 1:
        prime_idx_list.append(1)

    answer = 1
    if len(prime_idx_list) == 0:
        return 2

    for prime_count in prime_idx_list:
        answer *= prime_count + 1
    return answer


if __name__ == "__main__":
    param = 2147395600
    param = 1
    answer = solution(param)
    print(f"Answer : {answer}")
    assert answer == 8
