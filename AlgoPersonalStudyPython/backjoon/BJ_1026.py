def main_function():
    n = int(input())

    arr_1 = list(map(int, input().split(' ')))
    arr_2 = list(map(int, input().split(' ')))
    arr_1.sort()
    arr_2.sort()
    answer = 0
    for i in range(0, n):
        answer += arr_1[n-i-1] * arr_2[i]
    print(answer)


if __name__ == '__main__':
    main_function()
