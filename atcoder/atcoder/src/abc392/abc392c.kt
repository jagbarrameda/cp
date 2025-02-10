fun main() {
    val n = readln().toInt()
    val p = readln().split(" ").map { it.toInt() - 1 }
    val q = readln().split(" ").map { it.toInt() - 1 }
    val bibtop = IntArray(n)
    for (i in 0 until n) {
        bibtop[q[i]] = i
    }
    val ans = mutableListOf<Int>()
    for (i in 0 until n) {
        ans.add(q[p[bibtop[i]]] + 1)
    }
    println(ans.joinToString(" "))
}