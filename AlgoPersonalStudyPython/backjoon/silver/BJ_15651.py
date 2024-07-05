import sys


list_sb = list()


def main():
    val_n, val_m = map(int, sys.stdin.readline().split())
    list_int = [0 for m in range(val_m)]
    list_int2 = list()

    for n in range(val_n):
        list_int2.append(n+1)
    for n in range(val_n):
        list_int[val_m - 1] = n + 1
        backtracking(list_int2, list_int, val_m-1)
    print("".join(list_sb))


def backtracking(list_int, list_answer, dep):
    if dep == 0:
        for idx in range(len(list_answer)-1, 0):
            list_sb.append(list_answer[idx] + " ")
        list_sb.append("\n")
    for idx in range(len(list_int)):
        list_answer[dep-1] = idx + 1
        backtracking(list_int, list_answer, dep - 1)


if __name__ == "__main__":
    main()
