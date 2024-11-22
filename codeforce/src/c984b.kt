import java.util.Arrays.sort

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (n, k) = readln().split(" ").map { it.toInt() }
        val b = IntArray(k)
        val c = IntArray(k)
        var i = 0
        while (i < k) {
            val (bi, ci) = readln().split(" ").map { it.toInt() }
            b[i] = bi
            c[i] = ci
            i++
        }
        val maxI = b.max() + 1
        val r = IntArray(maxI)
        i = 0
        while (i < k) {
            r[b[i]] += c[i]
            i++
        }
        sort(r)
        var ans = 0
        i = 0
        while (i < n && r.size - 1 - i >= 0 && r[r.size - 1 - i] > 0) {
            ans += r[r.size - 1 - i]
            i++
        }
        println(ans)
    }
}