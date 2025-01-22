fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val s1 = readln()
        val s2 = readln()
        val ans = minTime(s1, s2)
        println(ans)
    }
}

fun minTime(s1: String, s2: String): Int {
    var k = 0
    while (k < s1.length && k < s2.length && s1[k] == s2[k]) {
        k++
    }
    var ans = k
    if (k > 0)
        ans++
    ans += s1.length - k
    ans += s2.length - k
    return ans
}
