package c2040

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        if (n == 1) {println(1); continue}
        if (n == 2 || n == 3 || n==4) {println(2); continue}
        var ans = 2
        var cnt = 4
        while (cnt < n) {
            cnt = 2*(cnt+1)
            ans++
        }
        println(ans)
    }
}