class Solution:
    def intToRoman(self, num: int) -> str:
        return self.intToRoman_optimization(num)

    def intToRoman_optimization(self, num: int) -> str:
        roman_dict = {
            0: "",
            1: "I",
            4: "IV",
            5: "V",
            9: "IX",
            10: "X",
            40: "XL",
            50: "L",
            90: "XC",
            100: "C",
            400: "CD",
            500: "D",
            900: "CM",
            1000: "M",
        }
        answer: str = ""
        for idx in range(3, -1, -1):
            num_id = int(num / (10**idx))
            num_origin = num_id * (10**idx)

            if num_id == 9 or num_id == 4:
                answer += roman_dict[num_origin]
            elif num_id >= 5:
                answer += roman_dict[5 * (10**idx)]
                for _ in range(num_id - 5):
                    answer += roman_dict[(10**idx)]
            else:
                for _ in range(num_id):
                    answer += roman_dict[(10**idx)]
            num = num % (10**idx)
        return answer

    def intToRoman_origin(self, num: int) -> str:
        m_count = int(num / 1000)
        num -= m_count * 1000

        h_count = int(num / 100)
        num -= h_count * 100

        cm_count = 0
        cd_count = 0
        d_count = 0
        c_count = 0
        if h_count == 9:
            cm_count = 1
        elif h_count >= 5:
            d_count += 1
            c_count = h_count - 5
        elif h_count == 4:
            cd_count = 1
        else:
            c_count = h_count

        t_count = int(num / 10)
        num -= t_count * 10

        xc_count = 0
        xl_count = 0
        l_count = 0
        x_count = 0
        if t_count == 9:
            xc_count = 1
        elif t_count >= 5:
            l_count += 1
            x_count = t_count - 5
        elif t_count == 4:
            xl_count = 1
        else:
            x_count = t_count

        ix_count = 0
        iv_count = 0
        v_count = 0
        i_count = 0
        if num == 9:
            ix_count = 1
        elif num >= 5:
            v_count += 1
            i_count = num - 5
        elif num == 4:
            iv_count = 1
        else:
            i_count = num

        answer: str = ""
        for _ in range(m_count):
            answer += "M"
        for _ in range(cm_count):
            answer += "CM"
        for _ in range(d_count):
            answer += "D"
        for _ in range(cd_count):
            answer += "CD"
        for _ in range(c_count):
            answer += "C"
        for _ in range(xc_count):
            answer += "XC"
        for _ in range(l_count):
            answer += "L"
        for _ in range(xl_count):
            answer += "XL"
        for _ in range(x_count):
            answer += "X"
        for _ in range(ix_count):
            answer += "IX"
        for _ in range(v_count):
            answer += "V"
        for _ in range(iv_count):
            answer += "IV"
        for _ in range(i_count):
            answer += "I"

        return answer
