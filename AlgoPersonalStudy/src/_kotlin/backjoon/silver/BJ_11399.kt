package _kotlin.backjoon.silver

import java.io.*
import java.util.*

class BJ_11399 {
    fun solution(){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val n = Integer.parseInt(br.readLine())

        val arr = IntArray(n)
        val st = StringTokenizer(br.readLine())
        for (i in 0 until n) {
            arr[i] = st.nextToken().toInt()
        }
        Arrays.sort(arr)
        var answer = 0
        for(i in 0 until n){
            answer += arr[n-i-1] * (i+1)
        }
        println(answer)
    }
}
fun main(){
    val solutionClass = BJ_11399()
    solutionClass.solution()
}