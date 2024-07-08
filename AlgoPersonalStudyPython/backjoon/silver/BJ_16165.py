import sys


def main():
    val_n, val_m = map(int, sys.stdin.readline().split())
    group_list = dict()
    for n in range(val_n):
        group_name = sys.stdin.readline().rstrip()
        member_count = int(sys.stdin.readline().rstrip())
        for member in range(member_count):
            group_list[sys.stdin.readline().rstrip()] = group_name

    for m in range(val_m):
        name = sys.stdin.readline().rstrip()
        quiz_type = int(sys.stdin.readline().rstrip())
        if quiz_type == 0:
            answer_list = list()
            for key in group_list.keys():
                if group_list[key] == name:
                    answer_list.append(key)
            answer_list.sort()
            print(*answer_list, sep="\n")
        else:
            group_name = group_list[name]
            print(group_name)


if __name__ == "__main__":
    main()
