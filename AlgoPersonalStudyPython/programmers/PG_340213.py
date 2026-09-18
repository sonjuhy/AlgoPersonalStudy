def solution(video_len, pos, op_start, op_end, commands):
    answer = ""
    video_len_time = str_to_second(video_len)
    pos_time = str_to_second(pos)
    op_start_time = str_to_second(op_start)
    op_end_time = str_to_second(op_end)
    now_time = (
        op_end_time
        if pos_time < op_end_time and pos_time >= op_start_time
        else pos_time
    )

    for command in commands:
        if command == "next":
            now_time += 10
            if now_time > video_len_time:
                now_time = video_len_time
            if now_time < op_end_time and now_time >= op_start_time:
                now_time = op_end_time
        elif command == "prev":
            now_time -= 10
            if now_time < 0:
                now_time = 0
            if now_time < op_end_time and now_time >= op_start_time:
                now_time = op_end_time
    answer = to_time_str(now_time)
    return answer


def to_time_str(seconds: int) -> str:
    m: int = seconds // 60
    s: int = seconds % 60
    return f"{m:02d}:{s:02d}"


def str_to_second(time: str) -> int:
    min_time = int(time[:2])
    second_time = int(time[3:])
    return min_time * 60 + second_time
