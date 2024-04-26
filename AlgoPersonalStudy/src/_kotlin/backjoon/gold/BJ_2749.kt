package _kotlin.backjoon.gold

import java.io.BufferedReader
import java.io.InputStreamReader

class BJ_2749 {
    fun solution(){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val n = br.readLine().toLong()
        val divNum = 1000000

        val p = divNum / 10 * 15
        val fibo = IntArray(p)

        for (i in 2 until p) {
            fibo[i] = fibo[i - 1] + fibo[i - 2]
            fibo[i] %= divNum
        }
        println(fibo[p - 1])
    }
}
fun main(){

}