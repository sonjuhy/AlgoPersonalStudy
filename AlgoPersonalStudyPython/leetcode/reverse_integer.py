class Solution:
    def reverse(self, x: int) -> int:
        sign: bool = x >= 0
        x_str: str = ""
        front_zero_check: bool = True
        for s in str(x)[::-1]:
            if s == "0" and front_zero_check:
                continue
            if s == "-":
                continue
            front_zero_check = False
            x_str += s
        x = int(x_str if x_str != "" else "0")

        if x < -(2**31) + 1 or x > 2**31 - 1:
            return 0
        if not sign:
            x = x * -1

        return x

    def reverse_fast(self, x: int) -> int:
        sign: bool = x >= 0
        x = int(str(abs(x))[::-1])
        if not sign:
            x = x * -1

        if x < -(2**31) + 1 or x > 2**31 - 1:
            return 0

        return x
