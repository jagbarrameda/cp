fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        var ans = if (n==1 && m==1) 1 else if (m == n) 0 else m - n
        println(ans)
    }
}
