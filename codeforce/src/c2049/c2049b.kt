fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val s = readln()
        if (s.count { it == 's' } == 0 || s.count { it == 'p' } == 0) {
            println("YES")
            continue
        }
        var ans = true
        ans = (s[0] == 's' && s.count { it == 's' } == 1) || (s[s.length-1] == 'p' && s.count { it == 'p' } == 1)
        println(if (ans) "YES" else "NO")
    }
}
