import sys
from queue import Queue


global_str_container = []
global_boolean_map = []


def main():
    val_n,val_m,val_v = map(int, sys.stdin.readline().split())
    dfs_set = []
    bfs_set = []
    global_boolean_map = [[False for m in range(val_m + 1)] for n in range(val_n + 1)]
    for m in range(val_m):
        val_a, val_b = map(int, sys.stdin.readline().split())
        global_boolean_map[val_a][val_b] = True
        global_boolean_map[val_b][val_a] = True
        dfs_set.append(val_a)
        dfs_set.append(val_b)
        bfs_set.append(val_a)
        bfs_set.append(val_b)
    if dfs_set.__contains__(val_v):
        pass
    else:
        print(val_v)
        print(val_v)


def dfs(hashset: [], val_v: int, dep: int):
    if len(hashset) > 0:
        global_str_container.append(val_v)
        global_str_container.append(" ")

        hashset.remove(val_v)
        tmp_set_list = hashset.copy()
        for num in tmp_set_list:
            if hashset.__contains__(num):
                if global_boolean_map[val_v][num]:
                    dfs(hashset, num, dep+1)


def bfs(hashset: [], val_v: int, val_n: int):
    str_container = []
    queue = Queue()
    queue.put(val_v)
    while not queue.empty():
        queue_size = queue.qsize()
        for q in range(queue_size):
            num = queue.get()
            if not hashset.__contains__(num):
                continue
            hashset.remove(num)
            str_container.append(num)
            str_container.append(" ")
            for des in hashset:
                if global_boolean_map[num][des]:
                    queue.put(des)
    print(str_container)


if __name__ == "__main__":
    main()
