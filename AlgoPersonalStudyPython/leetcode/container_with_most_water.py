from typing import List


class Solution:
    def maxArea(self, height: List[int]) -> int:
        if len(height) <= 2:
            return min(height[0], height[1])
        answer: int = 0
        left_idx = 0
        right_idx = len(height) - 1
        while left_idx < right_idx:
            answer = max(answer, self.calc_water(height, left_idx, right_idx))

            if height[left_idx] < height[right_idx]:
                left_idx += 1
            else:
                right_idx -= 1
        return answer

    def calc_water(self, height: List[int], start_idx: int, end_idx: int) -> int:
        h = min(height[start_idx], height[end_idx])
        w = end_idx - start_idx
        return h * w
