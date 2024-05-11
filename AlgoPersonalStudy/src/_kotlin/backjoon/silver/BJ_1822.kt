package _kotlin.backjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BJ_1822 {
    fun solution(){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        val set = HashSet<Long>()

        var st = StringTokenizer(br.readLine())
        while(st.hasMoreTokens()){
            set.add(st.nextToken().toLong())
        }
        st = StringTokenizer(br.readLine())
        while(st.hasMoreTokens()){
            set.remove(st.nextToken().toLong())
        }
        if(set.isEmpty()) print(0)
        else{
            println(set.size)
            set.sorted()
            val sb = StringBuilder()
            for(num: Long in set){
                sb.append(num).append(" ")
            }
            println(sb.toString())
        }
    }
    fun solutionFromJava(){
        val br = BufferedReader(InputStreamReader(System.`in`))
        var st = StringTokenizer(br.readLine())
        val A = st.nextToken().toInt()
        val B = st.nextToken().toInt()

        val hashSet = HashSet<Long>()

        st = StringTokenizer(br.readLine())
        for (a in 0 until A) {
            val num = st.nextToken().toLong()
            hashSet.add(num)
        }

        st = StringTokenizer(br.readLine())
        for (b in 0 until B) {
            val num = st.nextToken().toLong()
            hashSet.remove(num)
        }
        if (hashSet.isEmpty()) {
            println(0)
        } else {
            println(hashSet.size)
            val list = ArrayList(hashSet)
            list.sort()
            val sb = java.lang.StringBuilder()
            for (num in list) {
                sb.append(num).append(" ")
            }
            println(sb.toString())
        }
    }
}
fun main(){
    val solutionClass = BJ_1822()
    solutionClass.solution()
}