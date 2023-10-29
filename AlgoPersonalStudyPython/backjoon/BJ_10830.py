import copy


def main_function():
    n, b = list(map(int, input().split(' ')))

    map_list = [[] for i in range(n)]
    for num in range(0, n):
        map_list[num] = list(map(int, input().split()))
    result_list = copy.deepcopy(map_list)
    matrix = []
    while b > 0:
        if b & 1 == 1:
            matrix.append(result_list)
        if b > 1:
            tmp_matrix = [[0 for j in range(n)] for i in range(n)]

            for row in range(n):
                for col in range(n):
                    for i in range(n):
                        tmp_matrix[row][col] += result_list[row][i] * result_list[i][col]
                    if tmp_matrix[row][col] > 1000:
                        tmp_matrix[row][col] = tmp_matrix[row][col] % 1000
            result_list = copy.deepcopy(tmp_matrix)
        b = b >> 1

    result_list = copy.deepcopy(matrix.pop())
    for mat in matrix:
        tmp_matrix = [[0 for j in range(n)] for i in range(n)]
        for row in range(n):
            for col in range(n):
                for i in range(n):
                    tmp_matrix[row][col] += result_list[row][i] * mat[i][col]
                if tmp_matrix[row][col] > 1000:
                    tmp_matrix[row][col] = tmp_matrix[row][col] % 1000

        result_list = copy.deepcopy(tmp_matrix)

    for row in range(n):
        for col in range(n):
            print(result_list[row][col] % 1000, end=' ')
        print()


if __name__ == "__main__":
    main_function()
