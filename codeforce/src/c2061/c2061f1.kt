import java.util.*

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val s = readln()
        val ta = readln()
        val n = s.length
        var l = 0
        var r = n-1
        var ans = 0
        while (l < r) {
            while (l < r && s[l]==ta[l]) {
                l++
            }
            while (l < r && s[r]==ta[r]) {
                r--
            }
            if (l >= r) break
            var next = l + 1
            while (next < r && s[l]==s[next] && ta[l]==ta[next]) next++
            if (next >= r) {
                // not possible
                break
            }
            if (s[next+1]==s[next] || ta[next+1]==ta[next]) {
                // not possible
                break
            }

        }
        println(if (l < r) -1 else ans)
    }
}
