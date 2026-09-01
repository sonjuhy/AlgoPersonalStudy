class Solution:
    def letterCombinations(self, digits: str) -> list[str]:
        dial_dict: dict[int, list] = {
            2: ["a", "b", "c"],
            3: ["d", "e", "f"],
            4: ["g", "h", "i"],
            5: ["j", "k", "l"],
            6: ["m", "n", "o"],
            7: ["p", "q", "r", "s"],
            8: ["t", "u", "v"],
            9: ["w", "x", "y", "z"],
        }
        answer = []
        for n_str in digits:
            num = int(n_str)
            if len(answer) == 0:
                for char in dial_dict[num]:
                    answer.append(char)
            else:
                tmp_list = []
                for a_char in answer:
                    for char in dial_dict[num]:
                        tmp_list.append(a_char + char)
                answer = tmp_list

        return answer
