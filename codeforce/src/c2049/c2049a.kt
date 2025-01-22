fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val a = readln().split(" ").map { it.toInt() }
        if (a.count { it == 0 } == a.size) {
            println(0)
            continue
        }
        var first = -1
        var last = -1
        for (i in a.indices) {
            if (a[i] != 0 && first == -1) first = i
            if (a[i] != 0) last = i
        }
        var zero = a.subList(first, last).contains(0)
        println(if (zero) 2 else 1)
    }
}
