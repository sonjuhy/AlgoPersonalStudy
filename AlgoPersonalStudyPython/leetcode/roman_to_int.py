class Solution:
    def romanToInt(self, s: str) -> int:
        roman_dict:dict[str, int] = {'I':1, 'V':5, 'X':10, 'L':50,'C':100,'D':500,'M':1000}
        answer = 0
        before_char = ''
        for char in s:
            add_num = roman_dict[char]
            if before_char == 'I':
                if char == 'V' or char == 'X':
                    add_num -= 2
            elif before_char == 'X':
                if char == 'L' or char == 'C':
                    add_num -= 20
            elif before_char == 'C':
                if char == 'D' or char == 'M':
                    add_num -= 200

            answer += add_num
            before_char = char
        return answer
