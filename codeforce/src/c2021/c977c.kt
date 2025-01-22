package c2021

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (n, m, k) = readln().split(' ').map { it.toInt() }
        var ans = IntArray(n)
        var j = 0
        for (i in n downTo m + 1) {
            ans[j++] = i
        }
        for (i in 1 .. m) {
            ans[j++] = i
        }
        println(ans.joinToString(" "))
    }
}