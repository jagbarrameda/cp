fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        var (l, r, i, k) = readln().split(" ").map { it.toLong() }
        val a = xorAllInteresting(l, i.toInt(), k.toInt())
        val b = xorAllInteresting(r + 1, i.toInt(), k.toInt())
        println(a xor b)
    }
}

fun xorAll(n: Long) : Long {
    // n exclusive
    // every 4 numbers, xor is 0
    if (n % 4 == 0L) return 0
    if (n % 4 == 1L) return n - 1
    if (n % 4 == 2L) return 1
    return n
}

fun xorAllInteresting(n: Long, i: Int, k: Int) : Long {
    // n exclusive
    var ans = xorAll(n)
    var cnt = (n - 1) shr i
    if ((n - 1) - (cnt shl i) < k)
        cnt--
    if (cnt >= 0) {
        ans = ans xor (xorAll(cnt + 1) shl i)
        if ((cnt + 1) % 2 == 1L) {
            ans = ans xor k.toLong()
        }
    }
    return ans
}
