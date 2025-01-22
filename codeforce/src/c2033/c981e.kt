fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val a = readln().split(" ").map { it.toInt() - 1 }
        var ans = 0
        for (i in a.indices) {
            if (i == a[i] || i == a[a[i]]) {
                ans++
            }
        }
        println(a.size - ans)
    }
}