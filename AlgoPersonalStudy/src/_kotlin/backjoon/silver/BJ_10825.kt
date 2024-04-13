package _kotlin.backjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = Integer.parseInt(br.readLine())

    val stack = Stack<Int>()

    val sb = StringBuilder()
    for(i:Int in 0 until n){
        val strArr = br.readLine().split(" ")
        if ("push" == strArr[0]) {
            stack.push(strArr[1].toInt())
        } else if ("pop" == strArr[0]) {
            if (stack.isEmpty()) sb.append(-1).append("\n") else {
                sb.append(stack.pop()).append("\n")
            }
        } else if ("size" == strArr[0]) {
            sb.append(stack.size).append("\n")
        } else if ("empty" == strArr[0]) {
            if (stack.isEmpty()) sb.append(1).append("\n") else sb.append(0).append("\n")
        } else if ("top" == strArr[0]) {
            if (stack.isEmpty()) sb.append(-1).append("\n") else {
                sb.append(stack.peek()).append("\n")
            }
        }
    }
    println(sb.toString())
}