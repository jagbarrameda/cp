import java.io.PrintWriter

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (n, m) = C2055C.io.nextInts()
        val s = C2055C.io.nextLine()
        val a = Array(n) { C2055C.io.nextLongs().toLongArray() }
        val rowsMisses = LongArray(n)
        val colsMisses = LongArray(m)
        var rowMisses = 1L
        var colMisses = 1L
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

        val rowSum=a.map { it.sum() }.toLongArray()
        val colSum=LongArray(m)
        for (col in 0 until m) { for (row in 0 until n) { colSum[col] += a[row][col] } }

        // x is set
        // mark path
        var changed = true
        while (changed) {
            changed = false
            row = 0
            col = 0
            var i = 0
            while (row < n && col < m) {
                if (rowsMisses[row] == 1L) {
                    a[row][col] = -rowSum[row]
                    rowSum[row]+=a[row][col]
                    colSum[col]+=a[row][col]
                    rowsMisses[row]--
                    colsMisses[col]--
                    changed = true
                } else if (colsMisses[col] == 1L) {
                    a[row][col] = -colSum[col]
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
            C2055C.io.writeLine(a[row].joinToString(" "))
        }
    }
    C2055C.io.flush()
}

object C2055C {
    object io {
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
}