import kotlin.math.abs

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (_, q) = readln().split(' ').map { it.toInt() }
        val a = readln().split(' ').map { it.toInt() }
        val diff = Array(a.size) { if (it + 1 < a.size) abs(a[it] - a[it + 1]) else 0 }
        val sparseTable = SparseTable(diff) { x, y -> C2050f.gcd(x, y) }
        val ans = IntArray(q)
        for (i in 0 until q) {
            val (l, r) = readln().split(' ').map { it.toInt() }
            ans[i] = sparseTable.query(l - 1, r - 1)
        }
        println(ans.joinToString(" "))
    }
}


class SparseTable(a: Array<Int>, val f: (Int, Int) -> Int) {
    private val maxN = a.size
    private val st = Array(a.size + 1) { IntArray(maxN) }

    init {
        st[0] = a.toIntArray()
        for (i in 1 until st.size) {
            var j = 0
            while (j + (1 shl i) < st.size) {
                st[i][j] = f(st[i - 1][j], st[i - 1][j + (1 shl (i - 1))])
                j++
            }
        }
    }

    fun query(left: Int, right: Int): Int {
        var ans = 0
        var l = left
        for (i in st.size - 1 downTo 0) {
            if ((1 shl i) <= right - l + 1) {
                ans = f(ans, st[i][l])
                l += 1 shl i
            }
        }
        return ans
    }
}

object C2050f {
    fun gcd(a: Int, b: Int): Int {
        if (a == 0) return b
        if (b == 0) return a
        if (a == b) return a
        if (a > b) return gcd(a - b, b)
        return gcd(a, b - a)
    }
}