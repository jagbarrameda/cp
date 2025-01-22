import java.io.PrintWriter
import java.util.Collections.sort
import kotlin.math.min

fun main() {
//    c2053dSt.solSt()
    c2053d1.solve()
}


object c2053d1 {
    val mod = 998244353
    fun solve() {
        var t = readln().toInt()
        while (t-- > 0) {
            val (n, q) = c2053d.nextInts()
            val aOrig = c2053d.nextInts().toMutableList()
            val bOrig = c2053d.nextInts().toMutableList()
            val a = aOrig.toMutableList()
            val b = bOrig.toMutableList()
            sort(a)
            sort(b)
            val ans = mutableListOf<Int>()
            var qq = q

            var v = 1
            for (i in 0 until n) {
                v = ((1L * v * min(a[i], b[i])) % mod).toInt()
            }
            ans.add(v)

            while (qq-- > 0) {
                val (o, x) = c2053d.nextInts()
                if (o == 1) {
                    val orig = aOrig[x - 1]
                    val i = find(orig, a)
                    if (a[i] < b[i]) {
                        //  ans = (v + (v * mod / a[j])) % mod // todo: is it possible to find the new v??
                        v = ((1L * v * qpow(a[i]) % mod * (a[i] + 1L) % mod) % mod).toInt()
                    }
                    aOrig[x - 1]++
                    a[i]++
                } else {
                    val orig = bOrig[x - 1]
                    val i = find(orig, b)
                    bOrig[x - 1]++
                    if (b[i] < a[i]) {
                        //  ans = (v + (v * mod / a[j])) % mod // todo: is it possible to find the new v??
                        v = ((1L * v * qpow(b[i]) % mod * (b[i] + 1L) % mod) % mod).toInt()
                    }
                    b[i]++
                }
                ans.add(v)
            }
            c2053d.write("${ans.joinToString(" ")}\n")
        }
        c2053d.done()
    }

    fun qpow(aa: Int, xx: Int = mod - 2): Int {
        var res = 1
        var a = aa
        var x = xx
        while (x > 0) {
            if (x and 1 > 0)
                res = ((1L * res * a) % mod).toInt()
            x = x shr 1
            a = ((1L * a * a) % mod).toInt()
        }
        return res
    }

    fun find(v: Int, a: List<Int>): Int {
        var l = 0
        var r = a.size - 1
        while (l <= r) {
            val mid = l + (r - l) / 2
            if (a[mid] <= v) {
                l = mid + 1
            } else {
                r = mid - 1
            }
        }
        return l - 1
    }
}

object c2053dSt {
    val mod = 998244353
    fun solve() {
        var t = readln().toInt()
        while (t-- > 0) {
            val (n, q) = c2053d.nextInts()
            val aOrig = c2053d.nextInts().toMutableList()
            val bOrig = c2053d.nextInts().toMutableList()
            val a = aOrig.toMutableList()
            val b = bOrig.toMutableList()
            sort(a)
            sort(b)
            val ans = mutableListOf<Int>()
            var qq = q

            val minimums = mutableListOf<Int>()
            for (i in 0 until n) {
                minimums.add(min(a[i], b[i]))
            }
            val st = getSegTree(minimums)
            ans.add(st[1])

            while (qq-- > 0) {
                val (o, x) = c2053d.nextInts()
                var i = x - 1
                if (o == 1) {
                    val orig = aOrig[x - 1]
                    i = find(orig, a)
                    aOrig[x - 1]++
                    a[i]++
                } else {
                    val orig = bOrig[x - 1]
                    i = find(orig, b)
                    bOrig[x - 1]++
                    b[i]++
                }
                updateSt(min(a[i], b[i]), i, st)
                ans.add(st[1])
            }
            c2053d.write("${ans.joinToString(" ")}\n")
        }
        c2053d.done()
    }

    private fun getSegTree(a: MutableList<Int>): IntArray {
        val n = a.size
        val st = IntArray(2 * n)
        for (i in n - 1 downTo 0) {
            st[n + i] = a[i]
        }
        for (i in n - 1 downTo 1) {
            st[i] = ((1L * st[2 * i] * st[2 * i + 1]) % mod).toInt()
        }
        return st
    }

    private fun updateSt(v: Int, i: Int, st: IntArray) {
        var p = i + st.size / 2
        st[p] = v
        p = p shr 1
        while (p > 0) {
            st[p] = ((1L * st[p shl 1] * st[(p shl 1) + 1]) % mod).toInt()
            p = p shr 1
        }
    }

    fun find(v: Int, a: List<Int>): Int {
        var l = 0
        var r = a.size - 1
        while (l <= r) {
            val mid = l + (r - l) / 2
            if (a[mid] <= v) {
                l = mid + 1
            } else {
                r = mid - 1
            }
        }
        return l - 1
    }
}

object c2053d {


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