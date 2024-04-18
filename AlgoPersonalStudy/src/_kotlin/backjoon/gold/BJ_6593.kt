package _kotlin.backjoon.gold

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BJ_6593 {
    private val deltaX = arrayOf(0, 1, 0, -1)
    private val deltaY = arrayOf(1, 0, -1, 0)
    private val deltaZ = arrayOf(1, -1)
    fun solution(){
        val br = BufferedReader(InputStreamReader(System.`in`))
        while(true){
            val (L, R, C) = br.readLine().split(" ").map { it.toInt() }
            if(L == R && L == C && L == 0){
                break
            }

            val building = Array(L) {
                Array(R) {
                    CharArray(C)
                }
            }
            val time = Array(L) {
                Array(R) {
                    IntArray(
                        C
                    )
                }
            }
            val visited = Array(L) {
                Array(R) {
                    BooleanArray(C)
                }
            }

            val start = IntArray(3) { 0 }
            val end = IntArray(3) { 0 }

            for(l:Int in 0 until L){
                for(r:Int in 0 until R){
                    val tmp = br.readLine().toCharArray()
                    for(c:Int in 0 until C){
                        building[l][r][c] = tmp[c]
                        if(tmp[c] == 'S'){
                            start[0] = l
                            start[1] = r
                            start[2] = c
                        } else if (tmp[c] == 'E') {
                            end[0] = l
                            end[1] = r
                            end[2] = c
                        }
                    }
                }
                br.readLine()
            }

            var count = 0
            visited[start[0]][start[1]][start[2]] = true

            val queue = LinkedList<IntArray>()
            queue.add(start)
            while(!queue.isEmpty()){
                val queueSize = queue.size
                count++
                for(q:Int in 0 until queueSize){
                    val point = queue.poll()
                    val z = point[0]
                    val y = point[1]
                    val x = point[2]

                    for(d:Int in 0 .. 3){
                        val dy = deltaY[d] + y
                        val dx = deltaX[d] + x
                        if (dy < 0 || dy >= R || dx < 0 || dx >= C) continue
                        if (building[z][dy][dx] == '#') continue
                        if (!visited[z][dy][dx]) {
                            visited[z][dy][dx] = true
                            time[z][dy][dx] = count
                            queue.add(intArrayOf(z, dy, dx))
                        }
                    }
                    for(d:Int in 0 .. 1){
                        val dz = deltaZ[d] + z
                        if (dz < 0 || dz >= L) continue
                        if (building[dz][y][x] == '#') continue
                        if (!visited[dz][y][x]) {
                            visited[dz][y][x] = true
                            time[dz][y][x] = count
                            queue.add(intArrayOf(dz, y, x))
                        }
                    }
                }
            }

            val goal = time[end[0]][end[1]][end[2]]
            if(goal == 0){
                println("Trapped!")
            }
            else{
                println("Escaped in {} minute(s)".format(goal))
            }
        }
    }
}
fun main(){
    val solutionClass = BJ_6593()
    solutionClass.solution()
}