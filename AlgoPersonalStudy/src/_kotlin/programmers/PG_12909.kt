package _kotlin.programmers

import java.util.*

class PG_12909 {
    fun solution(str:String):Boolean{
        var answer = true
        val charArr = str.toCharArray()
        if(charArr.size % 2 == 1) return false

        val stack = Stack<Char>()
        for(c:Char in charArr){
            if(c == '(') stack.push(c)
            else{
                if(stack.isEmpty()){
                    answer = false
                    break
                }
                stack.pop()
            }
        }
        if(!stack.isEmpty()) answer = false
        return answer
    }
}
fun main(){
    val str = "(()("
    val solutionClass = PG_12909()
    println(solutionClass.solution(str))
}
