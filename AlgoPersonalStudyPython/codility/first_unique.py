def solution(A):
    dict_a = {}
    for a in A:
        if a in dict_a.keys():
            dict_a[a] += 1
        else:
            dict_a[a] = 1

    for a in A:
        if dict_a[a] == 1:
            return a
    return -1
