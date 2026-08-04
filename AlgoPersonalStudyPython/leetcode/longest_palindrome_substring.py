class Solution:
    def longestPalindrome(self, s: str) -> str:
        return self.central(s)

    def central(self, s: str) -> str:
        # 1. 길이가 2 미만, 이미 palindrome 문자 인 경우 그대로 리턴
        # 2. 전 인덱스 돌며 확장하며 확인
        # 3. 짝수 palindrome, 홀수 palindrome 문자 구분하여 검사
        # 4. 과거 포함, 가장 긴(길이) 문자 갱신
        # 5. 리턴

        if len(s) < 2 or s == s[::-1]:
            return s

        longest_palindrome = ""
        for idx in range(len(s) - 1):
            odd_longest_palindrome = self.valid_palindrome(s, idx, idx)
            even_longest_palindrome = self.valid_palindrome(s, idx, idx + 1)
            longest_palindrome = max(
                longest_palindrome,
                odd_longest_palindrome,
                even_longest_palindrome,
                key=len,
            )

        return longest_palindrome

    def valid_palindrome(self, s: str, left: int, right: int) -> str:
        s_list = list(s)
        left_idx = left
        right_idx = right
        while (
            left_idx >= 0
            and right_idx < len(s)
            and s_list[left_idx] == s_list[right_idx]
        ):
            left_idx -= 1
            right_idx += 1
        return s[left_idx + 1 : right_idx]
