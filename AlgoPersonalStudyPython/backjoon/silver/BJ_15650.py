import sys


def main():
    val_n, val_m = map(int, sys.stdin.readline().split())
    list_int = list()
    list_bool = list()

    for n in range(val_n):
        list_int.append(n + 1)
    backtracking(list_int, list_bool, 0, val_m)


def backtracking(list_int, list_bool, start, dep):
    if dep == 0:
        for idx in range(len(list_int)):
            if list_bool[idx]:
                print(list_int[idx] + " ")
        return
    for idx in range(start, len(list_int)):
        list_bool[idx] = True
        backtracking(list_int, list_bool, idx + 1, dep-1)
        list_bool[idx] = False


if __name__ == "__main__":
    main()
