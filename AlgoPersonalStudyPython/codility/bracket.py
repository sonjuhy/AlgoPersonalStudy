# N is an integer within the range [0..200,000];
# string S is made only of the following characters: '( ', '{ ', '[ ', '] ', '} ' and/or ')'.


def solution(S):
    len_s = len(S)
    if len_s == 0:
        return 1
    open_list = ["[", "(", "{"]
    close_list = ["]", ")", "}"]
    stack = []
    for s in S:
        if s in open_list or len(stack) == 0:
            stack.append(s)
        elif s in close_list:
            if s == "]" and stack[-1] == "[":
                stack.pop()
            elif s == ")" and stack[-1] == "(":
                stack.pop()
            elif s == "}" and stack[-1] == "{":
                stack.pop()
            else:
                stack.append(s)

    if len(stack) == 0:
        return 1
    else:
        return 0
