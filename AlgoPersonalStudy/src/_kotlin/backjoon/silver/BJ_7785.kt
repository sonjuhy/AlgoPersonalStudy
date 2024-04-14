package _kotlin.backjoon.silver

import java.io.*;
import java.lang.StringBuilder
import java.util.*;
import java.util.stream.Collectors
import kotlin.collections.HashSet

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toLong()

    val people = HashSet<String>()
    for(n:Long in 0 until N){
        val st = StringTokenizer(br.readLine())
        val name = st.nextToken()
        val action = st.nextToken()
        if("enter" == action){
            people.add(name)
        }
        else{
            people.remove(name)
        }
    }
    val sb = StringBuilder()
    for(person:String in people.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList())){
        sb.append(person).append("\n")
    }
    println(sb.toString())
}