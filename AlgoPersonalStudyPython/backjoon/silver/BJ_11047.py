import sys


def main():
    val_n, val_k = map(int, sys.stdin.readline().split())
    answer = 0
    left_coin = val_k
    coins = []
    for n in range(val_n):
        coins.append(int(sys.stdin.readline().rstrip()))
    if val_k == coins[val_n - 1]:
        answer = 1
    else:
        for n in range(val_n-1, 0):
            div = left_coin / coins[n]
            if div > 0:
                answer += div
                left_coin %= coins[n]
    print(answer)


if __name__ == "__main__":
    main()
