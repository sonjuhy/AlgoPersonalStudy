from collections.abc import Callable, Sequence
from typing import Any


class Debugging:
    def __init__(self, func: Callable[[], Any]):
        super().__init__()
        self.func = func

    def running(self, datas: Sequence[Any], answers: Sequence[Any]) -> None:
        for idx, (data, answer) in enumerate(zip(datas, answers)):
            if isinstance(data, tuple):
                result = self.func(*data)
            else:
                result = self.func(data)
            assert result == answer, (
                f"\n[Case {idx} Failed]"
                f"\n- Input   : {data}"
                f"\n- Expected: {answer}"
                f"\n- Actual  : {result}"
            )
            print(f"Case {idx} Correct: {data} -> {result}")
