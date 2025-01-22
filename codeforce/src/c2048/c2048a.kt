fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        var s = readln()
        var n = s.toInt()
        if (n % 33 == 0) {
            n = 0
            s = ""
        }
        for (i in 0 until s.length - 1) {
            if (s[i] == s[i + 1] && s[i] == '3') {
                n = (s.substring(0, i) + s.substring(i + 2)).toInt()
                if (n % 33 == 0) {
                    n = 0
                    break
                }
            }
        }

        println(if (n == 0) "YES" else "NO")
    }
}
