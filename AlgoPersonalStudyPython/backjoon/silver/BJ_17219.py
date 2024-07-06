import sys


def main():
    val_n, val_m = map(int, sys.stdin.readline().split())
    pw_map = dict()
    for n in range(val_n):
        tmp_val1, tmp_val2 = map(str, sys.stdin.readline().split())
        pw_map[tmp_val1] = tmp_val2
    tmp_str = []
    for m in range(val_m):
        val_str = sys.stdin.readline()
        tmp_str.append(pw_map[val_str] + "\n")
    print("".join(tmp_str))
    

if __name__ == "__main__":
    main()
