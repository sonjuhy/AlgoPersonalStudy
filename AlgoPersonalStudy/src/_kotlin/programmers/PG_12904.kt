package _kotlin.programmers

import java.io.*
import java.util.*

fun main(){
    val s = ""
    val result = solution(s)
    println(result)
}
fun solution(s:String):Int{
    var answer = 0
    val orderArr = s.toCharArray()
    val arrLen = orderArr.size
    for(start:Int in 0 until arrLen){
        for(end:Int in start+1 until arrLen){
            var limitCompare = (end - start) / 2 + 1
            var sameCheck = true
            for(compare:Int in 0 until limitCompare){
                if(orderArr[compare + start] != orderArr[end - compare]){
                    sameCheck = false
                    break
                }
            }
            if(sameCheck) answer = answer.coerceAtLeast((end - start + 1))
        }
    }

    return answer
}