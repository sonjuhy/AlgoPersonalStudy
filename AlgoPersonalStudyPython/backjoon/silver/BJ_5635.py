import sys


def main_function():
    n = int(sys.stdin.readline().rstrip())
    young_person = ''
    young_age = [0, 0, 0]  # day, month, year
    old_person = ''
    old_age = [100, 100, 10000]  # day, month, year
    for i in range(n):
        people = sys.stdin.readline().split(' ')
        day = int(people[1])
        month = int(people[2])
        year = int(people[3])
        if year > young_age[2]:
            young_age[2] = year
            young_age[1] = month
            young_age[0] = day
            young_person = people[0]
        elif year == young_age[2]:
            if month > young_age[1]:
                young_age[2] = year
                young_age[1] = month
                young_age[0] = day
                young_person = people[0]
            elif month == young_age[1]:
                if day > young_age[0]:
                    young_age[2] = year
                    young_age[1] = month
                    young_age[0] = day
                    young_person = people[0]

        if year < old_age[2]:
            old_age[2] = year
            old_age[1] = month
            old_age[0] = day
            old_person = people[0]
        elif year == old_age[2]:
            if month < old_age[1]:
                old_age[2] = year
                old_age[1] = month
                old_age[0] = day
                old_person = people[0]
            elif month == old_age[1]:
                if day < old_age[0]:
                    old_age[2] = year
                    old_age[1] = month
                    old_age[0] = day
                    old_person = people[0]

    print(young_person)
    print(old_person)


if __name__ == '__main__':
    main_function()
