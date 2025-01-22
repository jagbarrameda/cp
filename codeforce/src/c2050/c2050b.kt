fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val a = readln().split(" ").map { it.toLong() }
        val sum = a.sum()
        var ans = true
        if (sum % n != 0L) {
            ans = false
        } else {
            val target = a.sum() / n
            val n1 = (n + 1) / 2
            var acc1 = target * n1
            val n2 = n / 2
            var acc2 = target * n2
            for (i in 0 until n step 2) {
                acc1 -= a[i]
            }
            for (i in 1 until n step 2) {
                acc2 -= a[i]
            }
            ans = (acc1 == 0L && acc2 == 0L)
        }
        println(if (ans) "YES" else "NO")
    }
}

/*
1
5
1 3 1 3 7


5
6 2 1 4 2
 */