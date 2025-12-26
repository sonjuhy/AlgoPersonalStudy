def solution(A):
    circle_list = []
    for idx, a in enumerate(A):
        circle_list.append([idx - a, -1])
        circle_list.append([idx + a, 1])
    circle_list = sorted(circle_list)

    answer = 0
    activated_circle_count = 0

    for _, status in circle_list:
        if status == -1:  # start circle
            answer += activated_circle_count
            activated_circle_count += 1
        else:  # end circle
            activated_circle_count -= 1

    if answer > 10000000:
        answer = -1

    return answer


if __name__ == "__main__":
    param = [1, 5, 2, 1, 4, 0]
    answer = solution(param)
    print(f"Answer : {answer}")
    assert answer == 11
