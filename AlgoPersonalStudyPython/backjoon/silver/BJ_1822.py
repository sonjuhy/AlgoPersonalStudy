import sys


def main():
    val_a, val_b = map(int, sys.stdin.readline().split())
    hashset = set()
    list_a = sys.stdin.readline().split()
    for a in range(val_a):
        hashset.add(int(list_a.pop(a)))

    list_b = sys.stdin.readline().split()
    for b in range(val_b):
        hashset.remove(int(list_b.pop(b)))

    if len(hashset) == 0:
        print(0)
    else:
        print(len(hashset))
        tmp_list = list(hashset)
        sorted(tmp_list)
        tmp_str = []
        for item in tmp_list:
            tmp_str.append(str(item) + " ")
        print("".join(tmp_str))


if __name__ == "__main__":
    main()
