import java.io.PrintWriter
import kotlin.time.measureTime

fun main() {
    val n: Int
    val qn: Int
    var qs: Array<Pair<Int, Char>>
    val logQnSize = 200001
    var timeTaken = measureTime {
        val l1 = c2051g.nextInts()
        n = l1[0]
        qn = l1[1]
        qs = Array(qn) {
            val l = c2051g.nextLine().split(" ")
            l[0].toInt() - 1 to l[1][0]
        }
    }
    if (qn == logQnSize) {
        c2051g.writeLine("Read Input in ${timeTaken.inWholeMilliseconds}ms")
        c2051g.flush()
    }


    val minD: Array<IntArray>
    val maxLength: IntArray
    timeTaken = measureTime {
        // get minD
        val gap = Array(n) { IntArray(n) { 0 } }
        minD = Array(n) { IntArray(n) { 1 } }
        maxLength = IntArray(n) { 1 }

        for (q in qs) {
            if (q.second == '+') {
                maxLength[q.first]++
                for (i in 0 until n) {
                    if (i == q.first) {
                        continue
                    }
                    gap[q.first][i] -= 1
                    if (gap[q.first][i] < 0) {
                        minD[q.first][i]++
                        gap[q.first][i] = 0
                    }
                }
            } else {
                for (i in 0 until n) {
                    if (i == q.first) {
                        continue
                    }
                    gap[i][q.first] += 1
                }
            }
        }
    }
    if (qn == logQnSize) {
        c2051g.writeLine("Computed minD in ${timeTaken.inWholeMilliseconds}ms")
        c2051g.flush()
    }

    val nMask = 1 shl n
    val cntToMasks: Array<MutableList<Int>>
//    val maskToIdx: Array<MutableList<Int>>
    timeTaken = measureTime {
        cntToMasks = Array(n + 1) { mutableListOf<Int>() }
        for (mask in 1 until nMask) {
            cntToMasks[mask.countOneBits()].add(mask)
        }
//        maskToIdx = Array(nMask) { mutableListOf<Int>() }
//        for (mask in 1 until nMask) {
//            var vMask = mask
//            var idx = 0
//            while (vMask != 0) {
//                if (vMask and 1 != 0) {
//                    maskToIdx[mask].add(idx)
//                }
//                idx++
//                vMask = vMask shr 1
//            }
//        }
    }
    if (qn == logQnSize) {
        c2051g.writeLine("Computed cntToMasks in ${timeTaken.inWholeMilliseconds}ms")
        c2051g.flush()
    }


    // get dp
    val dp: Array<IntArray>
    timeTaken = measureTime {
        dp = Array(nMask) { IntArray(n) { Int.MAX_VALUE } }
        // dp[mask][i] -> the soonest position possible for snake i (where i is the last snake in mask) when all snakes in mask are placed
        for (i in 0 until n) {
            dp[1 shl i][i] = 1 // only snake i is placed, it gets the first place
        }
        for (cnt in 2..n) {
            for (mask in cntToMasks[cnt - 1]) {
                // for all configurations with cnt - 1 snakes placed
                for (i in 0 until n) {
                    if (mask and (1 shl i) != 0) {
                        continue // do not use snake i as it is already placed in mask
                    }
                    val newMask = mask or (1 shl i)
                    for (j in 0 until n) {
                        if (mask and (1 shl j) == 0) continue
                        if (dp[newMask][i] > dp[mask][j] + minD[j][i]) {
                            dp[newMask][i] = dp[mask][j] + minD[j][i]
                        }
                    }
                }
            }
        }
    }
    if (qn == logQnSize) {
        c2051g.writeLine("Computed dp in ${timeTaken.inWholeMilliseconds}ms")
        c2051g.done()
    }

    // get ans
    var ans: Int
    timeTaken = measureTime {
        ans = Int.MAX_VALUE
        for (i in 0 until n) {
            if (ans > dp[nMask - 1][i] + maxLength[i] - 1) {
                ans = dp[nMask - 1][i] + maxLength[i] - 1
            }
        }
    }
    if (qn == logQnSize) {
        c2051g.writeLine("Computed ans in ${timeTaken.inWholeMilliseconds}ms")
        c2051g.flush()
    }

    c2051g.writeLine("$ans")
    c2051g.done()
}

object c2051g {
    val cin = System.`in`.bufferedReader()
    val cout = PrintWriter(System.out.bufferedWriter())
    val endl = "\n"
    val space = " "
    fun nextLine() = cin.readLine()!!.trim()
    fun nextInt() = nextLine().toInt()
    fun nextLong() = nextLine().toLong()
    fun nextStrings() = nextLine().split(space)
    fun nextInts() = nextStrings().map { it.toInt() }
    fun nextLongs() = nextStrings().map { it.toLong() }
    fun write(a: Int) = cout.write(a.toString() + space)
    fun write(s: String) = cout.write(s)
    fun writeLine(s: String) = cout.write("$s$endl")
    fun flush() = cout.flush()
    fun done() = cout.flush()
}

