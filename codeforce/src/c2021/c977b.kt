package c2021

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        var (n, x) = readln().split(" ").map { it.toInt() }
        val a = readln().split(" ").map { it.toInt() }
        if (a.min() != 0) {
            println(0)
            continue
        }

        val cnt = IntArray(n)
        for (i in a) {
            if (i < n) {
                cnt[i]++
            }
        }
        var i = 0
        while (i < a.size && cnt[i] > 0) {
            var j = 1
            while (cnt[i] > 1 && i + j * x < n) {
                cnt[i]--
                cnt[i + j * x]++
                j++
            }
            i++
        }
        println(i)
    }
}
