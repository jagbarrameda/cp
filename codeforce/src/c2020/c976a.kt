fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        var (n, k) = readln().split(" ").map { it.toInt() }
        if (k == 1) {
            println("$n")
            continue
        }
        if (n == 1) {
            println("1")
            continue
        }
        var ans = 0
        while (n > 0) {
            ans += n % k
            n /= k
        }
        println(ans)
    }
}