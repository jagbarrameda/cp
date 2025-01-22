fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        var (k, l1, r1, l2, r2) = readln().split(" ").map { it.toLong() }
        var ans = 0L
        for (x in l1..r1) {
            // for each l1 + {0 .. k-1 (or r1)}
            var num = x
            if (num > r2) break
            while (num < l2) {
                num *= k
            }
//            val cnt = log(0.0 + r2 - num, k.toDouble()).toInt() - 1
//            ans += cnt
            while (num <= r2) {
                ans++
                num *= k
            }
        }
        println(ans)
    }
}