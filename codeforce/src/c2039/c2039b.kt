fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val s = readln()
        var ans = ""
        // either two equal consecutive chars or 4 distinct

        for (i in 1 until s.length) {
            if (s[i] == s[i - 1]) {
                ans = s.substring(i - 1, i + 1)
                break
            }
            if (i < 2) {
                continue
            }
            val s2 = s.substring(i - 2, i + 1)
            if (s2[0] != s2[1] && s2[0] != s2[2] && s2[1] != s2[2]) {
                ans = s2
                break
            }
        }

        if (ans == "") {
            println(-1)
        } else {
            println(ans)
        }
    }
}
