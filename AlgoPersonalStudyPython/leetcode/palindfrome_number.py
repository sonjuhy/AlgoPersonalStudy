class Solution:
    def isPalindrome(self, x: int) -> bool:
        num_list: list = list(str(x))
        len_num: int = len(num_list)
        for idx in range(len_num):
            if num_list[idx] != num_list[len_num - idx - 1]:
                return False
        return True
