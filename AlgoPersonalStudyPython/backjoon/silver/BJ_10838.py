import sys


def main():
    val_n = int(sys.stdin.readline().rstrip())
    stack = list()
    tmp_sb = list()

    for n in range(val_n):
        list_str = sys.stdin.readline().split()
        if "push" == list_str[0]:
            stack.append(int(list_str[1]))
        elif "pop" == list_str[0]:
            if len(stack) == 0:
                tmp_sb.append("-1\n")
            else:
                tmp_sb.append(str(stack.pop()) + "\n")
        elif "size" == list_str[0]:
            tmp_sb.append(str(len(stack)) + "\n")
        elif "empty" == list_str[0]:
            if len(stack) == 0:
                tmp_sb.append("1\n")
            else:
                tmp_sb.append("0\n")
        elif "top" == list_str[0]:
            if len(stack) == 0:
                tmp_sb.append("-1\n")
            else:
                tmp_sb.append(str(stack.index(len(stack) - 1)) + "\n")
    print("".join(tmp_sb))


if __name__ == "__main__":
    main()
