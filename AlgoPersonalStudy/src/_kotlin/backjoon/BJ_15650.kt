package _kotlin.backjoon

import java.io.*
import java.util.*

fun main(){
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(bf.readLine())
    val N = Integer.parseInt(st.nextToken())
    val M = Integer.parseInt(st.nextToken())

    val arr = IntArray(N) { n -> n+1 }
    val visited = BooleanArray(N)
    backTracking(arr, visited, 0, M)
}
fun backTracking(arr:IntArray, visited:BooleanArray, start:Int, dep:Int){
    if(dep == 0){
        for(i:Int in arr.indices){
            if(visited[i]) print(""+arr[i] + " ")
        }
        println()
        return
    }
    for(i:Int in start until arr.size){
        visited[i] = true
        backTracking(arr, visited, i+1, dep - 1)
        visited[i] = false
    }
}