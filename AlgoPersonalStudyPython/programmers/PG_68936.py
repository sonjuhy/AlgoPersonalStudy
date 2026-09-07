def solution(arr):
    answer = [0, 0]
    length = len(arr)

    answer = check_quard(arr, 0, 0, length)
    return answer


def check_quard(arr: list, x_start_idx: int, y_start_idx: int, len_idx: int):
    data = arr[y_start_idx][x_start_idx]
    is_compress: bool = True
    for y_idx in range(y_start_idx, y_start_idx + len_idx):
        for x_idx in range(x_start_idx, x_start_idx + len_idx):
            if data != arr[y_idx][x_idx]:
                is_compress = False
                break
    answer = [0, 0]
    if is_compress:
        answer = [1, 0] if data == 0 else [0, 1]
    else:
        half_len = int(len_idx / 2)
        answer_1st = check_quard(arr, x_start_idx, y_start_idx, half_len)
        answer_2nd = check_quard(arr, x_start_idx + half_len, y_start_idx, half_len)
        answer_3rt = check_quard(arr, x_start_idx, y_start_idx + half_len, half_len)
        answer_4th = check_quard(
            arr, x_start_idx + half_len, y_start_idx + half_len, half_len
        )

        answer[0] += answer_1st[0] + answer_2nd[0] + answer_3rt[0] + answer_4th[0]
        answer[1] += answer_1st[1] + answer_2nd[1] + answer_3rt[1] + answer_4th[1]
    return answer
