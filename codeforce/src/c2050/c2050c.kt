fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val s = readln()
        var rem = 0
        var t2 = 0
        var t3 = 0
        for (i in s.indices) {
            val d = s[i] - '0'
            rem = (rem + d) % 9
            if (d == 2) t2++
            if (d == 3) t3++
        }
        var ans = false
        val target = (9 - rem) % 9
        for (i in 0 .. t2) {
            for (j in 0 .. t3) {
                if ((2*i + 6*j) % 9 == target) {
                    ans = true
                    break
                }
            }
            if (ans) break
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