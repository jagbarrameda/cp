fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val a = readln().split(" ").map { it.toInt() }
    val ans = mutableListOf<Int>()
    for (i in 1..n) {
        if (!a.contains(i)) {
            ans += i
        }
    }
    println(ans.size)
    if (ans.size > 0) println(ans.joinToString(" "))
}