package _kotlin.backjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs

class BJ_11286 {
    fun solution(){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val n = Integer.parseInt(br.readLine())
        val pq = PriorityQueue(Comparator.comparingInt { a: IntArray -> a[0] }
            .thenComparingInt { a: IntArray ->
                a[1]
            })

        val sb = StringBuilder(br.readLine())
        for(i:Int in 0 until n){
            val x = Integer.parseInt(br.readLine())
            if(x == 0){
                if(!pq.isEmpty()){
                    val polledData =pq.poll()
                    sb.append(polledData[1]).append("\n")
                }
                else{
                    sb.append(0).append("\n")
                }
            }
            else{
                pq.add(intArrayOf(abs(x),x))
            }
        }
        println(sb.toString())
    }
}
fun main(){
    val solutionClass = BJ_11286()
    solutionClass.solution()
}