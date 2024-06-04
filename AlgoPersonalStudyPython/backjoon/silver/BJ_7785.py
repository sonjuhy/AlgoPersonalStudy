import sys


def solution():
    n = int(sys.stdin.readline().rstrip())
    people = {}
    for i in range(0, n):
        person_log = sys.stdin.readline().rstrip().split(" ")
        person = person_log[0]
        action = person_log[1]
        if action == "enter":
            people[person] = "enter"
        elif action == "leave" and person in people:
            people.pop(person)

    print('\n'.join(sorted(people, reverse=True)))


if __name__ == "__main__":
    solution()
