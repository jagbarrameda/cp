import kotlin.math.min

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val sb = StringBuilder(readln())
        for (i in sb.indices) {
            var bestJ = i
            var bestScore = sb[i] - '0'
            val up = min(sb.length, i + 10)
            for (j in i + 1 until up) {
                val curr = sb[j] - '0' - (j - i)
                if (curr > bestScore) {
                    bestJ = j
                    bestScore = curr
                }
            }
            for (j in bestJ downTo i + 1) {
                sb[j] = sb[j - 1]
            }
            sb[i] = '0' + bestScore
        }
        println(sb)
    }
}
