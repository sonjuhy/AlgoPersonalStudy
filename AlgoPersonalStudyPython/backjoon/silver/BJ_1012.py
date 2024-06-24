import sys


def main():
    delta_x = [0, 1, 0, -1]
    delta_y = [1, 0, -1, 0]
    val_t = int(sys.stdin.readline().rstrip())
    for t in range(val_t):
        val_m, val_n, val_k = map(int, sys.stdin.readline().split())
        int_map = [[0 for m in range(val_m)] for n in range(val_n)]
        boolean_visited = [[False for m in range(val_m)] for n in range(val_n)]

        for k in range(val_k):
            val_x, val_y = map(int, sys.stdin.readline().split())
            int_map[val_y][val_x] = 1

        answer = 0
        queue = []
        for n in range(val_n):
            for m in range(val_m):
                if int_map[n][m] == 1:
                    if not boolean_visited[n][m]:
                        boolean_visited[n][m] = True
                        answer += 1
                        queue.append([n, m])
                        while len(queue) > 0:
                            tmp_data = queue.pop()
                            for d in range(4):
                                dy = tmp_data[0] + delta_y[d]
                                dx = tmp_data[1] + delta_x[d]
                                if 0 <= dy < val_n and 0 <= dx < val_m:
                                    if int_map[dy][dx] == 1 and not boolean_visited[dy][dx]:
                                        boolean_visited[dy][dx] = True
                                        queue.append([dy, dx])
        print(answer)


if __name__ == "__main__":
    main()
