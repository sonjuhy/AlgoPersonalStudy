package _kotlin.backjoon.silver

import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val N = Integer.parseInt(st.nextToken())
    val K = Integer.parseInt(st.nextToken())

    val coins = IntArray(N)
    for(n:Int in 0 until N){
        coins[n] = Integer.parseInt(br.readLine())
    }
    var answer = 0
    var leftCoin = K

    if(coins[N-1] == K){
     answer = 1
    }
    else {
        for(coin:Int in N-1 downTo 0){
            val div = leftCoin / coins[coin]
            if(div > 0){
                answer += div
                leftCoin %= coins[coin]
            }
        }
    }
    println(answer)
}