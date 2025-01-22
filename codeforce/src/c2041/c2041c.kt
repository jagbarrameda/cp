package c2041

import java.io.PrintWriter
import kotlin.math.min

// practicing; compare with the fastest c++ solution

fun main() {
    val n = C2041C.next_int()
    val cube = Array(n) { Array(n) { C2041C.next_line().split(" ").map { it.toInt() }.toTypedArray() } }

    // NN = 2^n <= 2^12 = 4096
    // NN is the number of different combinations of choosing i in n, for i = 1..n
    // e.g. n=3 => NN = 2^3=8 = cardinality({ 000, 001, 010, 011, 100, 101, 110, 111})
    // let's call S the set of all possible ways to select 0 or more elements in n,
    // E.g. for n = 3, S= { 000, 001, 010, 011, 100, 101, 110, 111}
    // a mask m is an element of S
    val NN = 1 shl n
    // dp - best value of a single floor
    // dp[m1][m2] is the best value when all rows in m1 and cols in m2 are occupied,
    // for all possible ways of combining rows and cols.
    // E.g. n=2, dp[01][01] - best value when row 0 and col 0 are occupied (only one way)
    // E.g. n=2, dp[11][11] - best value for choosing two cubes in the 2x2 plane: [[1,0][0,1]] and [[0,1][1,0]]
    val dp = Array(NN) { IntArray(NN) { 0 } }
    // floors[i] is the list of possible combinations of i \in [1..n] used indexes in n
    // E.g. n=3,
    // floors[1] = {001, 010, 100},
    // floors[2] = {011, 101, 110},
    // floors[3] = {111}
    // (floors is 1-indexed, so floors[0] = {} ignored)
    val floors = Array(n + 1) { mutableListOf<Int>() }
    // rowsCols[mask]: list of indexes that are set in that mask
    // if the mask represents the used rows, then rowsCols[mask] is the list of indexes of used rows
    // this is used to iterate easily over the row indexes given its mask
    // E.g. n=3,
    // rowsCols[001] = {0} => rows 0 is used
    // rowsCols[101] = {0,2} => rows 0 and 2 are used
    val rowsCols = Array(NN) { mutableListOf<Int>() }

    for (mask in 1 until NN) {
        // mask.countOneBits(): how many cubes already chosen for the mask
        // at 1 cube per floor, means it takes that many floors (same for columns and rows)
        floors[mask.countOneBits()].add(mask)
        var j = mask
        while (j > 0) {
            // j is a mask,
            // j.countTrailingZeroBits(): the smallest index row (or col) that is occupied
            val i = j.countTrailingZeroBits()
            rowsCols[mask].add(i)
            j = j xor (1 shl i) // remove that last smallest index
        }
        // e.g now rowsCols[110] = {1, 2} => rows 1 and 2 are used
    }

    for (f in 1..n) {
        for (m1 in floors[f]) {
            for (m2 in floors[f]) {
                dp[m1][m2] = Int.MAX_VALUE
                for (r in rowsCols[m1]) {
                    for (c in rowsCols[m2]) {
                        // update dp[m1][m2]
                        // with the best value found so far and
                        // the same rows and cols chosen, but leaving r and c free,
                        // and choosing r and c at the previous floor, i.e. cube[f - 1][r][c]
                        dp[m1][m2] = min(
                            dp[m1][m2],
                            cube[f - 1][r][c] + dp[m1 xor (1 shl r)][m2 xor (1 shl c)]
                        )
                        // m1 xor (1 shl r) => disable row r
                        // m2 xor (1 shl c) => disable col c
//                        dp[m1 xor (1 shl r)][m2 xor (1 shl c)]
                    }
                }
            }
        }
    }
    // the answer is the current dp (now dp is the dp for the last floor)
    // occupying all the rows and all the columns, i.e. (1 << n) - 1
    val all = (1 shl n) - 1
    C2041C.cout.write("${dp[all][all]}\n")
    C2041C.cout.flush()
}

object C2041C {
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

/*

3
1089383 1030886 1092777
1036915 1047793 1038335
1085386 1060492 1016649
1041421 1002362 1090027
1068690 1020059 1097763
1013926 1080540 1083426
1089172 1055736 1005211
1095368 1002567 1056429
1065782 1021530 1022862

 */


/**

5
1 2 3 4 5
4 5 6 7 8
7 8 9 8 7
1 1 1 1 1
2 2 2 2 2
3 3 3 3 3
4 3 0 0 1
2 1 4 1 2
9 8 9 8 0
6 7 5 4 3
3 3 3 3 3
4 3 0 0 1
2 1 4 1 2
9 8 9 8 0
6 7 5 4 3
3 3 3 3 3
4 3 0 0 1
2 1 4 1 2
9 8 9 8 0
6 7 5 4 3
3 3 3 3 3
4 3 0 0 1
2 1 4 1 2
9 8 9 8 0
6 7 5 4 3

 */
