class Solution:
    def myAtoi(self, s: str) -> int:
        return self.myAtoi_optimization(s)

    def myAtoi_origin(self, s: str) -> int:
        num_set = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}
        sign: int = 1
        sign_check: bool = True
        space_check: bool = True
        num_str: str = ""
        for idx, char in enumerate(s):
            if char == " " and space_check:
                continue

            if sign_check and char == "-":
                sign = -1
            elif sign_check and char == "+":
                sign = 1
            else:
                if char in num_set:
                    num_str += char
                else:
                    break
            space_check = False
            sign_check = False
        if num_str == "":
            return 0

        answer = 0
        for idx, num in enumerate(num_str[::-1]):
            answer += int(num) * (10**idx)

        answer *= sign
        INT_MIN: int = -(2**31)
        INT_MAX: int = 2**31 - 1

        if answer < INT_MIN:
            return INT_MIN
        if answer > INT_MAX:
            return INT_MAX

        return answer

    def myAtoi_optimization(self, s: str) -> int:
        num_set = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}
        idx: int = 0
        sign: int = 1
        s_list: list = list(s)

        while idx < len(s_list):
            if s_list[idx] == " ":
                idx += 1
            else:
                break

        while idx < len(s_list):
            if s_list[idx] == "-":
                sign = -1
                idx += 1
            elif s_list[idx] == "+":
                idx += 1
            break

        INT_MIN: int = -(2**31)
        INT_MAX: int = 2**31 - 1
        answer: int = 0

        while idx < len(s_list):
            if s_list[idx] not in num_set:
                break
            answer = int(s_list[idx]) + (10 * answer)

            if answer * sign < INT_MIN:
                return INT_MIN
            if answer * sign > INT_MAX:
                return INT_MAX

            idx += 1

        return answer * sign
