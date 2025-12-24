from math import sqrt


def solution(N):
    if N == 1:
        return 4

    sqrt_num = int(sqrt(N))
    is_prime = True

    for i in range(2, sqrt_num):
        if N % i == 0:
            is_prime = False
            break

    if is_prime:
        return (1 + N) * 2

    div_num = 2
    div_list = []

    while N >= div_num:
        if N % div_num == 0:
            if N / div_num <= div_num:
                return int(div_num + N / div_num) * 2
            div_list.append(div_num)
        div_num += 1


if __name__ == "__main__":
    param = 30
    param = 81
    param = 1000000000
    param = 15486451
    # param = 982451653
    answer = solution(param)
    print(f"Answer : {answer}")
    assert answer == 22
    # for idx in range(1, param):
    #     answer = solution(idx)
    #     if answer < 0:
    #         print(f"idx : {idx}")
