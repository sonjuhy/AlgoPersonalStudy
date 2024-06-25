import sys
from queue import PriorityQueue


def main():
    val_n = int(sys.stdin.readline().rstrip())
    pq = PriorityQueue()

    str_container = []
    for n in range(val_n):
        val_x = int(sys.stdin.readline().rstrip())
        if val_x == 0:
            if not pq.empty():
                polled_data = pq.get()
                str_container.append(str(polled_data[1]))
                str_container.append("\n")
            else:
                str_container.append("0")
                str_container.append("\n")
        else:
            pq.put([abs(val_x), val_x])
    print(''.join(str_container))


if __name__ == "__main__":
    main()
