import sys


def main_function():
    tmp = input().split(' ')
    n = int(tmp[0])
    kind = tmp[1]
    game_info = {'Y': 1, 'F': 2, 'O': 3}

    gamer_wish_list = set()
    for _ in range(0, n):
        gamer_wish_list.add(sys.stdin.readline().rstrip())
    answer = int((len(gamer_wish_list)) / game_info[kind])
    print(answer)


if __name__ == '__main__':
    main_function()
