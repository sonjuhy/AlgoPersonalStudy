package _kotlin.backjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BJ_1764 {
    fun solution(){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())
        val N = st.nextToken().toInt()
        val M = st.nextToken().toInt()
        val nameSet = HashSet<String>()
        for (n in 0 until N) {
            val name = br.readLine()
            nameSet.add(name)
        }
        val list: MutableList<String> = ArrayList()
        val sb = StringBuilder()
        for (m in 0 until M) {
            val name = br.readLine()
            if (nameSet.contains(name)) {
                list.add(name)
            }
        }
        val pqSize = list.size
        list.sort()
        for (name in list) {
            sb.append(name).append("\n")
        }
        println(pqSize)
        println(sb.toString())
    }
}
fun main(){
    val solutionClass = BJ_1764()
    solutionClass.solution()
}