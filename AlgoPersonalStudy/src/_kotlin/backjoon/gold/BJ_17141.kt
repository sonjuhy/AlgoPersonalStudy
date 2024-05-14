package _kotlin.backjoon.gold

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BJ_17141 {
    var n = 0
    private var voidCount = 0
    var answer = Integer.MAX_VALUE
    val deltaX = arrayOf(1, 0, -1, 0)
    val deltaY = arrayOf(0, 1, 0, -1)
    var map:Array<Array<Int>>? = null
    private var success:Boolean = false
    private var checkedVirus: BooleanArray? = null
    private val virus = ArrayList<IntArray>()

    fun solution(){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (tmpN, m) = br.readLine().split(" ").map { it.toInt() }
        n = tmpN

        map = Array(n){Array(n){0} }
        var virusCount = 0

        for(y:Int in 0 until n){
            val st = StringTokenizer(br.readLine())
            for(x:Int in 0 until n){
                val num = Integer.parseInt(st.nextToken())
                map!![y][x] = num
                if(num == 2){
                    virus.add(intArrayOf(y,x))
                    virusCount++
                }
                else if(num == 1) voidCount++
            }
        }
        if(voidCount == n*n) println(0)
        else{
            checkedVirus = BooleanArray(virusCount)
            getPosition(virusCount, 0, 0, m)
            println(if(success) 0 else -1)

        }
    }
    private fun getPosition(virusCount:Int, start:Int, dep:Int, position:Int) {
        if(position == dep){
            var checkedPosition = 0
            val virusPosition = IntArray(position)
            for(i:Int in 0 until (checkedVirus?.size ?: 0)){
                if(checkedVirus!![i]){
                    virusPosition[checkedPosition++] = i
                }
            }
            if(BFS(virusPosition)) success = true
        }
        else{
            for(i:Int in start until virusCount){
                if(!checkedVirus!![i]){
                    checkedVirus!![i] = true
                    getPosition(virusCount, i+1, dep+1, position)
                    checkedVirus!![i] = false
                }
            }
        }
    }
    private fun BFS(virusPosition: IntArray):Boolean {
        val labs = LinkedList<IntArray>()
        var count = -1
        var success = false

        val visited = Array(n){BooleanArray(n)}
        for(index:Int in virusPosition){
            val tmpPosition = virus[index]
            labs.add(tmpPosition)
        }

        while(!labs.isEmpty()){
            val labSize = labs.size
            var working = false
            for(l:Int in 0 until labSize){
                val point = labs.poll()
                if(!visited[point[0]][point[1]]){
                    visited[point[0]][point[1]] = true
                    working = true
                    for(d:Int in 0 until 4){
                        val dx = deltaX[d] + point[1]
                        val dy = deltaY[d] + point[0]
                        if(dx < 0 || dx >= n || dy < 0 || dy >= n) continue
                        if(visited[dy][dx] || map!![dy][dx] == 1) continue
                        labs.add(intArrayOf(dy, dx))
                    }
                }
            }
            if(working) count++
        }
        if(checkSuccess(visited)){
            success = true
            answer = Math.min(answer, count)
        }
        return success
    }
    private fun checkSuccess(visited:Array<BooleanArray>):Boolean{
        var tmpCount = 0
        for(col in visited){
            for(row in col){
                if(!row) tmpCount++
            }
        }
        return tmpCount == voidCount
    }
}
fun main(){
    val solutionClass = BJ_17141()
    solutionClass.solution()
}