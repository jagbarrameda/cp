fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        var (n, m, k) = readln().split(' ').map { it.toLong() }
        var a = readln().split(' ').map { it.toLong() }.toMutableList()
        val b = readln().split(' ').map { it.toLong() }
        while (k-- > 0) {
            var besti = 0
            var best = 0L
            for (i in a.indices) {
                for (magic in b) {
                    if (best < a[i] and magic) {
                        besti = i
                        best = a[i] and magic
                    }
                }
            }
            a[besti] = best
        }
        println(a.sum())
    }
}
