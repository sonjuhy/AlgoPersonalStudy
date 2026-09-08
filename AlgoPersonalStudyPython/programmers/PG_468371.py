import math


def solution(signals: list[list[int]]) -> int:
    answer: int = -1
    signal_list: list[list[int]] = []
    signal_len_list = []

    for sig_idx, signal in enumerate(signals):
        signal_list.append([])
        signal_len_list.append(sum(signal))
        for light_idx, light in enumerate(signal):
            signal_list[sig_idx].extend([light_idx] * light)

    lcm = math.lcm(*signal_len_list)

    for idx in range(lcm):
        yellow_light: bool = True
        for signal in signal_list:
            if signal[int(idx % len(signal))] != 1:
                yellow_light = False
                break
        if yellow_light:
            answer = idx + 1
            break

    return answer
