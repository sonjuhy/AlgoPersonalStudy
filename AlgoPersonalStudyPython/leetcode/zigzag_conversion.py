class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1:
            return s
        floor_dict: dict[int, list[str]] = {}

        for num in range(numRows):
            floor_dict[num] = []

        floor: int = 0
        sign: int = -1
        for idx, char in enumerate(s):
            if floor == numRows - 1:
                sign = -1
            elif floor == 0:
                sign = 1

            floor_dict[floor].append(char)
            floor += sign

        answer: str = ""
        for idx in range(numRows):
            for char in floor_dict[idx]:
                answer += char
        return answer
