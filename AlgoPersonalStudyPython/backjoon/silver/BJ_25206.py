import sys


def main():
    total_grade = 0.0
    total_credit = 0.0
    for i in range(20):
        _, credit_str, grade_str = sys.stdin.readline().split()
        credit_float = float(credit_str)
        grade_float = change_to_grade(grade_str)
        if grade_float >= 0:
            total_grade += (grade_float * credit_float)
            total_credit += credit_float
    print(total_grade / total_credit)


def change_to_grade(grade: str) -> float:
    if grade == "A+":
        return 4.5
    elif grade == "A0":
        return 4.0
    elif grade == "B+":
        return 3.5
    elif grade == "B0":
        return 3.0
    elif grade == "C+":
        return 2.5
    elif grade == "C0":
        return 2.0
    elif grade == "D+":
        return 1.5
    elif grade == "D0":
        return 1.0
    elif grade == "F":
        return 0
    elif grade == "P":
        return -1


if __name__ == "__main__":
    main()
