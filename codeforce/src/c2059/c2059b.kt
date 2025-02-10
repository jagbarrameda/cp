fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (n, k) = readln().split(" ").map { it.toInt() }
        val a = readln().split(" ").map { it.toInt() }
        val maxLen = n - k + 1
        var lastB = 0
        var i = 0
        while (i < n) {
            var flag = false
            // take all possible sizes for a
            for (len in 1..maxLen) {
                val j = i + len // idx for b
                if (j >= n) break
                if (a[j] != lastB + 1) {
                    // eureka
                    flag = true
                    break
                }
            }
            if (flag) {
                break
            }

            // take all possible sizes for b
            for (len in 1..maxLen) {
                val j = i + len
                if (j >= n) break
                if (a[j] != lastB + len) {
                    // eureka
                    flag = true
                    lastB = lastB + len - 1
                    break
                }
            }

            if (flag) {
                break
            }

            i += 2
            lastB++
        }

        println(lastB + 1)
    }
}
