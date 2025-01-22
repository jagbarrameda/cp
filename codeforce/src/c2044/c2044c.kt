fun main() {
    var t = readln().toInt()
    while (t-->0){
        var (m, a, b, c) = readln().split(" ").map { it.toInt() }
        var ans = 0
        ans += Math.min(m, a)
        ans += Math.min(m, b)
        ans += Math.min(2*m - ans, c)
        println(ans)
    }
}