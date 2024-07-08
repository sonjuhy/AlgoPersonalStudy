import sys


def main():
    testcase_int = int(sys.stdin.readline().rstrip())
    for test_count in range(testcase_int):
        answer_str = "YES"
        stack_main = list(sys.stdin.readline().rstrip())
        stack_sub = list()
        last_bracket = ""
        for idx in range(len(stack_main)):
            bracket = stack_main.pop()
            if idx == 0 and bracket == "(":
                answer_str = "NO"
                break
            if last_bracket == "":
                last_bracket = bracket
                stack_sub.append(bracket)
            elif last_bracket == ")":
                if bracket == ")":
                    stack_sub.append(bracket)
                else:
                    stack_sub.pop()
                    if len(stack_sub) > 0:
                        last_bracket = stack_sub[len(stack_sub) - 1]
                    else:
                        last_bracket = ""
            else:
                answer_str = "NO"
                break
        if len(stack_sub) > 0:
            answer_str = "NO"
        print(answer_str)


if __name__ == "__main__":
    main()
