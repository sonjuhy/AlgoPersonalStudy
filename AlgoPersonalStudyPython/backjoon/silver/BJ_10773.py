import sys


def main():
    val_k = int(sys.stdin.readline().rstrip())
    stack = list()
    for k in range(val_k):
        val_n = int(sys.stdin.readline().rstrip())
        if val_n == 0:
            stack.pop()
        else:
            stack.append(val_n)
    sum_int = 0
    for item in stack:
        sum_int += item
    print(sum_int)


if __name__ == "__main__":
    main()
