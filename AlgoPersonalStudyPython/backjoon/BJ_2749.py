def main_function():
    n = int(input())
    if n == 1 or n == 2:
        print(1)
    else:
        mod = 1000000
        arr = [0] * int(mod / 150)
        arr[1] = 1
        for i in range(2, int(mod/150)):
            arr[i] = (arr[i-2] + arr[i-1]) % mod
        print(arr[n % int(mod/150)])


if __name__ == '__main__':
    main_function()
