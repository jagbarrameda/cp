fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val a = readln().split(" ").map { it.toLong() }
        val b = readln().split(" ").map { it.toLong() }
        var min = Long.MAX_VALUE
        var min2 = Long.MAX_VALUE
        for(i in b.indices) {
            if (a[i] - b[i] < min) {
                min2 = min
                min = a[i] - b[i]
            } else if (a[i] - b[i] < min2) {
                min2 = a[i] - b[i]
            }
        }
        println(if (min >= 0 || min2 - (-min) >= 0) "YES" else "NO")
    }
}
