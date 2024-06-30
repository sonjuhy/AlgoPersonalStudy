import sys
from queue import Queue


def main():
    max_len = 100001
    val_n, val_k = map(int, sys.stdin.readline().split())
    if val_n == val_k:
        print(0)
        return
    qu = Queue()
    map_int = []
    day = 0
    qu.put([0, val_n])
    while len(map_int) > 0:
        day += 1
        now = qu.get()
        dx = now[1] + 1
        if dx < max_len:
            if day < map_int[dx]:
                map_int[dx] = day
                qu.put([day, dx])
        dx = now[1] - 1
        if dx >= 0 and day < map_int[dx]:
            map_int[dx] = day
            qu.put([day, dx])
        dx = now[1] * 2
        if dx < max_len and day < map_int[dx]:
            map_int[dx] = day
            qu.put([day, dx])
    print(map_int[val_k])


if __name__ == "__main__":
    main()
