package _kotlin.backjoon.silver

import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = Integer.parseInt(br.readLine())

    val arr = IntArray(N)
    for(n:Int in 0 until N){
        arr[n] = Integer.parseInt(br.readLine())
    }
    Arrays.sort(arr)

    var maxWeight = 0
    for(rope:Int in arr.indices){
        maxWeight = maxWeight.coerceAtLeast(arr[rope] * (N - rope))
    }
    println(maxWeight)
}