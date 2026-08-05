from typing import List


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        return self.bruteforce(nums1, nums2)

    def bruteforce(self, nums1: List[int], nums2: List[int]) -> float:
        nums = []
        nums.extend(nums1)
        nums.extend(nums2)
        nums = sorted(nums)
        len_nums = len(nums)
        half_len_nums = int(len_nums / 2)
        if len_nums % 2 == 0:
            return (nums[half_len_nums] + nums[half_len_nums - 1]) / 2
        else:
            return nums[half_len_nums]
