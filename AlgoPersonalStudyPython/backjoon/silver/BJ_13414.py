import sys


def main():
    val_k, val_l = map(int, sys.stdin.readline().split())
    hashmap = dict()
    for l in range(val_l):
        number_str = sys.stdin.readline().rstrip()
        hashmap[number_str] = l
    tmp_list = []
    sorted(hashmap.items(), key=lambda x: x[1])
    count = 0
    for item in hashmap:
        count += 1
        tmp_list.append(item[0] + "\n")
        if count == val_k:
            break
    print("".join(tmp_list))


if __name__ == "__main__":
    main()
