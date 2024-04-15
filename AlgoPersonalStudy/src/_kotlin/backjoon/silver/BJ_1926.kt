package _kotlin.backjoon.silver

import java.io.*
import java.util.*

class BJ_1926 {
    val deltaX = arrayOf(0,1,0,-1)
    val deltaY = arrayOf(1,0,-1,0)
    fun solution(){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (n,m) = br.readLine().split(" ").map { it.toInt() }

        val map = Array(n){Array(m){0} }
        val visited = Array(n){Array(m){false} }

        for(y:Int in 0 until n){
            val strArr = br.readLine().split(" ").map { it.toInt() }
            for(x:Int in 0 until m){
                map[y][x] = strArr[x]
            }
        }
        val queue = LinkedList<Array<Int>>()
        var count = 0
        var maxSize = 0

        for(y:Int in 0 until n){
            for(x:Int in 0 until m){
                if(map[y][x] == 1){
                    if(!visited[y][x]){
                        count++
                        var tmpSize = 1
                        visited[y][x] = true
                        queue.add(arrayOf(y,x))
                        while(!queue.isEmpty()){
                            val tmp = queue.poll()
                            for(d:Int in 0 until 4){
                                val dy = tmp[0] + deltaY[d]
                                val dx = tmp[1] + deltaX[d]
                                if (dy in 0..<n && dx in 0 ..< m){
                                    if(map[dy][dx] == 1 && !visited[dy][dx]){
                                        visited[dy][dx] = true
                                        tmpSize++
                                        queue.add(arrayOf(dy, dx))
                                    }
                                }
                            }
                        }
                        maxSize = maxSize.coerceAtLeast(tmpSize)
                    }
                }
            }
        }
        println(count)
        println(maxSize)
    }
}
fun main(){
    val solutionClass = BJ_1926()
    solutionClass.solution()
}