import sys


def main():
    val_n = int(sys.stdin.readline().rstrip())
    arr = []
    for n in range(val_n):
        arr.append(int(sys.stdin.readline().rstrip()))
    sorted(arr)
    max_weight = 0
    for n in range(val_n):
        max_weight = max(max_weight, arr[n] * (val_n - n))
    print(max_weight)


if __name__ == "__main__":
    main()
