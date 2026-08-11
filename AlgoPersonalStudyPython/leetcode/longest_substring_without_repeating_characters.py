class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        s_list: list[str] = list(s)
        max_length = 0
        now_length = 0
        start_idx = 0
        end_idx = 0
        exist_char_set: set = set()

        while start_idx <= end_idx and end_idx < len(s_list):
            if s_list[end_idx] in exist_char_set:
                exist_char_set.remove(s_list[start_idx])
                start_idx += 1
                now_length -= 1
            else:
                exist_char_set.add(s_list[end_idx])
                now_length += 1
                end_idx += 1
                max_length = max(max_length, now_length)

        return max_length
