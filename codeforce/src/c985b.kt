fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val s = readln()
        val r = readln()
        val sb = StringBuilder(s)
        val ans = f(sb, r)
        println(if (ans) "YES" else "NO")
    }
}

fun f(sb:StringBuilder, r: String) : Boolean {
    var j = 0
    for (c in r) {
        var ans = false
        while (j < sb.length - 1) {
            if (sb[j] != sb[j + 1]) {
                sb[j] = c
                sb.deleteCharAt(j + 1)
                ans = true
                if (j > 0) j--
                break
            }
            j++
        }
        if (!ans) return false
    }
    return true
}

