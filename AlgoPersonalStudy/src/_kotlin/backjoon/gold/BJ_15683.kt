package _kotlin.backjoon.gold

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

class BJ_15683 {
    var N = 0
    var M:Int = 0
    var shadedCount:Int = 0
    var answer:Int = Int.Companion.MAX_VALUE
    lateinit var cctvDir: IntArray
    lateinit var map: Array<IntArray>
    val cctvList: MutableList<IntArray> = ArrayList()


    fun solution(){
        val br = BufferedReader(InputStreamReader(System.`in`))
        var st = StringTokenizer(br.readLine())
        N = st.nextToken().toInt()
        M = st.nextToken().toInt()
        map = Array<IntArray>(N) { IntArray(M) }
        for (n in 0 until N) {
            st = StringTokenizer(br.readLine())
            for (m in 0 until M) {
                val num = st.nextToken().toInt()
                map[n][m] = num
                if (num > 0) {
                    if (num < 6) {
                        cctvList.add(intArrayOf(num, n, m))
                    }
                    shadedCount++
                }
            }
        }
        cctvDir = IntArray(cctvList.size)
        comb(0, cctvList.size)
        println(answer)
    }

    fun comb(dep: Int, num: Int) {
        if (dep == num) {
            val localMap = Array(N) { IntArray(M) }
            for (n in 0 until N) {
                localMap[n] = map.get(n).clone()
            }
            var localShadedCount = 0
            for (idx in cctvList.indices) {
                val cctv: IntArray = cctvList.get(idx)
                when (cctv[0]) {
                    1 -> when (cctvDir.get(idx)) {
                        0 -> localShadedCount += searchDyUp(localMap, cctv)
                        1 -> localShadedCount += searchDxRight(localMap, cctv)
                        2 -> localShadedCount += searchDyDown(localMap, cctv)
                        3 -> localShadedCount += searchDxLeft(localMap, cctv)
                    }

                    2 -> when (cctvDir.get(idx)) {
                        0 -> {
                            localShadedCount += searchDyUp(localMap, cctv)
                            localShadedCount += searchDyDown(localMap, cctv)
                        }

                        1 -> {
                            localShadedCount += searchDxRight(localMap, cctv)
                            localShadedCount += searchDxLeft(localMap, cctv)
                        }
                    }

                    3 -> when (cctvDir.get(idx)) {
                        0 -> {
                            localShadedCount += searchDyUp(localMap, cctv)
                            localShadedCount += searchDxRight(localMap, cctv)
                        }

                        1 -> {
                            localShadedCount += searchDxRight(localMap, cctv)
                            localShadedCount += searchDyDown(localMap, cctv)
                        }

                        2 -> {
                            localShadedCount += searchDyDown(localMap, cctv)
                            localShadedCount += searchDxLeft(localMap, cctv)
                        }

                        3 -> {
                            localShadedCount += searchDyUp(localMap, cctv)
                            localShadedCount += searchDxLeft(localMap, cctv)
                        }
                    }

                    4 -> when (cctvDir.get(idx)) {
                        0 -> {
                            localShadedCount += searchDyUp(localMap, cctv)
                            localShadedCount += searchDxRight(localMap, cctv)
                            localShadedCount += searchDxLeft(localMap, cctv)
                        }

                        1 -> {
                            localShadedCount += searchDyUp(localMap, cctv)
                            localShadedCount += searchDyDown(localMap, cctv)
                            localShadedCount += searchDxRight(localMap, cctv)
                        }

                        2 -> {
                            localShadedCount += searchDyDown(localMap, cctv)
                            localShadedCount += searchDxRight(localMap, cctv)
                            localShadedCount += searchDxLeft(localMap, cctv)
                        }

                        3 -> {
                            localShadedCount += searchDyUp(localMap, cctv)
                            localShadedCount += searchDyDown(localMap, cctv)
                            localShadedCount += searchDxLeft(localMap, cctv)
                        }
                    }

                    5 -> {
                        localShadedCount += searchDyUp(localMap, cctv)
                        localShadedCount += searchDyDown(localMap, cctv)
                        localShadedCount += searchDxRight(localMap, cctv)
                        localShadedCount += searchDxLeft(localMap, cctv)
                    }
                }
            }
            //            System.out.println(Arrays.toString(cctvDir)+", unShaded area : " + (N*M - localShadedCount - shadedCount));
//            printMap(localMap);
            answer = min(answer, N * M - localShadedCount - shadedCount)
        } else {
            val cctv: IntArray = cctvList.get(dep)
            when (cctv[0]) {
                1, 3, 4 -> {
                    var d = 0
                    while (d < 4) {
                        cctvDir[dep] = d
                        comb(dep + 1, num)
                        d++
                    }
                }

                2 -> {
                    var d = 0
                    while (d < 2) {
                        cctvDir[dep] = d
                        comb(dep + 1, num)
                        d++
                    }
                }

                5 -> comb(dep + 1, num)
            }
        }
    }

    fun searchDyUp(localMap: Array<IntArray>, cctv: IntArray): Int {
        var localShadedCount = 0
        var dyUp = cctv[1] - 1
        while (dyUp >= 0) {
            if (localMap[dyUp][cctv[2]] == 0) {
                localMap[dyUp][cctv[2]] = -1
                localShadedCount++
                dyUp--
            } else if (localMap[dyUp][cctv[2]] != 6) dyUp-- else break
        }
        return localShadedCount
    }

    fun searchDyDown(localMap: Array<IntArray>, cctv: IntArray): Int {
        var localShadedCount = 0
        var dyDown = cctv[1] + 1
        while (dyDown < N) {
            if (localMap[dyDown][cctv[2]] == 0) {
                localMap[dyDown][cctv[2]] = -1
                localShadedCount++
                dyDown++
            } else if (localMap[dyDown][cctv[2]] != 6) dyDown++ else break
        }
        return localShadedCount
    }

    fun searchDxRight(localMap: Array<IntArray>, cctv: IntArray): Int {
        var localShadedCount = 0
        var dxRight = cctv[2] + 1
        while (dxRight < M) {
            if (localMap[cctv[1]][dxRight] == 0) {
                localMap[cctv[1]][dxRight] = -1
                localShadedCount++
                dxRight++
            } else if (localMap[cctv[1]][dxRight] != 6) dxRight++ else break
        }
        return localShadedCount
    }

    fun searchDxLeft(localMap: Array<IntArray>, cctv: IntArray): Int {
        var localShadedCount = 0
        var dxLeft = cctv[2] - 1
        while (dxLeft >= 0) {
            if (localMap[cctv[1]][dxLeft] == 0) {
                localMap[cctv[1]][dxLeft] = -1
                localShadedCount++
                dxLeft--
            } else if (localMap[cctv[1]][dxLeft] != 6) dxLeft-- else break
        }
        return localShadedCount
    }

}
fun main(){
    var solutionClass = BJ_15683()
    solutionClass.solution()
}