import kotlin.math.max

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        val s = readln()
        val a = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
        val rowsMisses = IntArray(n)
        val colsMisses = IntArray(m)
        var rowMisses = 1
        var colMisses = 1
        var row = 0
        var col = 0
        for (i in s.indices) {
            if (s[i] == 'D') {
                rowsMisses[row] = rowMisses
                rowMisses = 1
                colMisses++
                row++
            } else {
                colsMisses[col] = colMisses
                rowMisses++
                colMisses = 1
                col++
            }
        }
        colsMisses[m-1] = colMisses
        rowsMisses[n-1] = rowMisses

        val rowSum=a.map { it.sum() }.toIntArray()
        val colSum=IntArray(m)
        for (col in 0 until m) { for (row in 0 until n) { colSum[col] += a[row][col] } }

        var x = 0 // candidate
//        for (row in 0 until n) {
//            if (rowsMisses[row] == 1) x = max(x, rowSum[row])
//        }
//        for (col in 0 until m) {
//            if (colsMisses[col] == 1) x = max(x, colsMisses[col])
//        }

        // x is set
        // mark path
        var changed = true
        while (changed) {
            changed = false
            row = 0
            col = 0
            var i = 0
            while (row < n && col < m) {
                if (rowsMisses[row] == 1) {
                    a[row][col] = x - rowSum[row]
                    rowSum[row]+=a[row][col]
                    colSum[col]+=a[row][col]
                    rowsMisses[row]--
                    colsMisses[col]--
                    changed = true
                } else if (colsMisses[col] == 1) {
                    a[row][col] = x - colSum[col]
                    rowSum[row]+=a[row][col]
                    colSum[col]+=a[row][col]
                    rowsMisses[row]--
                    colsMisses[col]--
                    changed = true
                }
                if (i == s.length) {
                    row=n
                    col=m
                } else {
                    if (s[i] == 'D') row++
                    else col++
                    i++
                }
            }
        }
        for (row in 0 until n) {
            println(a[row].joinToString(" "))
        }
    }
}
