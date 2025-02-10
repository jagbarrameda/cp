fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val s = readln()
        var ans = s.length
        for (i in 0 until s.length - 1) {
            if (s[i] == s[i + 1]) {
                ans=1
                break
            }
        }
        println(ans)
    }
}