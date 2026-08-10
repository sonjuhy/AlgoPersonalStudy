class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # return self.bruteforce(nums, target)
        return self.hashtable(nums, target)

    def bruteforce(self, nums: List[int], target: int) -> List[int]:
        for s_idx, start in enumerate(nums):
            for e_idx, end in enumerate(nums):
                if e_idx <= s_idx:
                    continue
                if start + end == target:
                    return [s_idx, e_idx]

    def hashtable(self, nums: List[int], target: int) -> List[int]:
        nums_dict: dict[int, int] = {}
        for idx, num in enumerate(nums):
            diff_num = target - num
            if diff_num in nums_dict:
                return [nums_dict[diff_num], idx]

            nums_dict[num] = idx


# bruteforce
# Runtime : 3100ms, Beats : 5.00%
# Memory : 19.86MB, Beats : 71.90%

# hashtable
# Runtime : 4ms, Beats : 42.14%
# Memory : 20.42MB, 40.56%
