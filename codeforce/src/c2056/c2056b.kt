import java.util.Collections.sort

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val adj = Array(n) { readln().toCharArray().map { it - '0' }.toIntArray() }
        val l = mutableListOf<List<Int>>()
        val ans = mutableListOf<Int>()
        for (i in n .. 1) ans.add(i)
        for (i in 1 .. n) {
            val nei = adj[i].mapIndexed { index, _ -> index }.toMutableList()
            while (nei.size > 0) {
                val j=nei[nei.size - 1]
                if (!ans.contains(j)) {ans.add(j)}
            }
        }

        println(ans.reversed().joinToString { " " })
    }
}
