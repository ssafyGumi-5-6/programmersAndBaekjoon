package 임스와_함께하는_미니게임

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

//class Solution {
//    fun main(args: Array<String>) {
//        val br = BufferedReader(InputStreamReader(System.`in`))
//        val st = StringTokenizer(br.readLine())
//        val N = st.nextToken().toInt()
//        val gameType = st.nextToken()
//        val list = ArrayList<String>()
//
//        for (i in 0 until N) {
//            list.add(br.readLine())
//        }
//
//        val set: Set<String> = HashSet(list)
//        val sb = StringBuilder()
//
//        if (gameType == "Y") sb.append(set.size)
//        else if (gameType == "F") sb.append(set.size / 2)
//        else if (gameType == "O") sb.append(set.size / 3)
//        println(sb.toString())
//    }
//}