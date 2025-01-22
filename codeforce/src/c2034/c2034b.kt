fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (n,m,k) = readln().split(" ").map { it.toInt() }
        val s = readln()
        var i = 0
        var cnt = 0
        var ans = 0
        while (i < n) {
            if (s[i]=='1') {
                cnt = 0
                i++
                continue
            }
            cnt++
            if (cnt >= m) {
                // use timar
                ans++
                i += k
                cnt = 0
            } else {
                i++
            }

        }
        println(ans)
    }
}
