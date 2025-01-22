fun main() {
    val s = readln()
    val t = readln()
    var ans = "-1"
    for (idx in 0 until 27) {
        var i  = 1
        while (i < s.length && s[i]-'a'!=idx) i++
        if (i == s.length) continue
        var j = t.length - 2
        while (j >= 0 && t[j] - 'a' != idx) j--
        if (j < 0) continue
        val subs = s.substring(0, i) + t.substring(j)
        if (ans == "-1" || subs.length < ans.length) {
            ans = subs
        }
    }

    println(ans)
}
