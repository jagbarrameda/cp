package c2041

import java.io.PrintWriter

fun main() {
    // this gives TLE (the problem time limit is very tight even for cpp)
    val n = C2041C2.next_int()
    val cube = Array(n) { Array(n) { C2041C2.next_line().split(" ").map { it.toInt() }.toTypedArray() } }
    val NN = 1 shl n
//    val dp = Array(n) { Array(NN) { Array(NN) { -1 } } }
    var dpCurr = Array(NN) { IntArray(NN) { -1 } }

    var l = setOf<E>()
    for (floor in 0 until n) {
        val nextL = mutableSetOf<E>()
        val dpPrev = dpCurr
        dpCurr = Array(NN) { IntArray(NN) { -1 } }
        for (row in 0 until n) {
            for (col in 0 until n) {
                if (l.isEmpty()) {
                    val vR = (1 shl row)
                    val vC = (1 shl col)
                    dpCurr[vR][vC] = cube[floor][row][col]
                    nextL.add(E(vR, vC))
                    continue
                }
                // compute combinations with previous floor best values
                for ((visitedRows, visitedCols) in l) {
                    if (visitedRows and (1 shl row) != 0 || visitedCols and (1 shl col) != 0) continue
                    val vR = visitedRows or (1 shl row)
                    val vC = visitedCols or (1 shl col)
                    val v = cube[floor][row][col] + dpPrev[visitedRows][visitedCols]
                    if (dpCurr[vR][vC] == -1 || dpCurr[vR][vC] > v)
                        dpCurr[vR][vC] = v
                    nextL.add(E(vR, vC)) // signal to next level that it should use these indices (dp is not -1)
                }
            }
        }
        l = nextL
    }

    val ans = dpCurr[NN - 1][NN - 1]
    println(ans)
}

data class E(val vR: Int, val vC: Int)


object C2041C2 {
    val cin = System.`in`.bufferedReader()
    val cout = PrintWriter(System.out.bufferedWriter())
    val endl = "\n"
    val space = " "
    fun next_line() = cin.readLine()!!.trim()
    fun next_int() = next_line().toInt()
    fun next_strings() = next_line().split(space)
    fun next_array() = next_strings().map{ it.toInt() }
    fun write(a: Int) = cout.write(a.toString()+space)
}