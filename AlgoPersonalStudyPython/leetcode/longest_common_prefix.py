class Solution:
    def longestCommonPrefix(self, strs: list[str]) -> str:
        answer: str = ""

        reference_word = strs[0]
        for end_idx in range(len(reference_word) + 1):
            sliced_str = reference_word[:end_idx]
            prefix_status: bool = True
            for idx in range(1, len(strs)):
                if len(strs[idx]) < end_idx or strs[idx][:end_idx] != sliced_str:
                    prefix_status = False
                    break

            if prefix_status:
                answer = sliced_str

        return answer
