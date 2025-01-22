package c2063

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val a = Array(n - 1) { readln().split(" ").map { it.toInt() - 1 } }
        if (n == 2) {
            println(0)
            continue
        }
        val adj = mutableMapOf<Int, MutableSet<Int>>()
        for (e in a) {
            if (!adj.containsKey(e[0])) {
                adj[e[0]] = mutableSetOf()
            }
            adj[e[0]]!!.add(e[1])

            if (!adj.containsKey(e[1])) {
                adj[e[1]] = mutableSetOf()
            }
            adj[e[1]]!!.add(e[0])
        }
        val degs = adj.map { e -> Pair(e.key, e.value.size) }
        val best = degs.maxBy { it.second }
        val cnt = degs.count { e-> e.second == best.second }
        if (cnt >= 3) {
            println(best.second * 2 - 1)
            continue
        } else {
            val best2 = adj
                .filter { e -> e.key != best.first }
                .map { e ->
                    var size = e.value.size
                    if (e.value.contains(best.first)) size--
                    Pair(e.key, size)
                }.maxBy { it.second }
            println(best.second + best2.second - 1)
        }
    }
}

/*
1
5
1 2
1 3
2 4
3 5

 */