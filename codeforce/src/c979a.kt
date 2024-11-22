fun main() {
    var t = readln().toInt()
    while (t-->0) {
        val n = readln().toInt()
        val a = readln().split(" ").map { it.toInt() }
        val max = a.max()
        val min = a.min()
        val ans = (max - min) * (n - 1)
        println(ans)
    }
}