def main_function():
    n = int(input())
    result = ''

    for num in range(0, n):
        arr_tmp = list(map(int, input().split(' ')))
        arr = arr_tmp[1:]
        result += str(arr_tmp[0]) + ' '

        answer = 0
        repeat = True
        while repeat:
            repeat = False
            for p in range(1, 20):
                number = arr[p]
                point = -1
                for f in range(p-1, -1, -1):
                    if number < arr[f]:
                        point = f
                if point >= 0:
                    arr.pop(p)
                    if point > 0:
                        arr.insert(point, number)
                    else:
                        arr.insert(0, number)
                    answer += (p - point)
                    repeat = True
                    break
        result += str(answer) + '\n'
    print(result)


if __name__ == "__main__":
    main_function()
