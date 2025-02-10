import java.util.Collections.sort
import java.util.stream.IntStream.range
import kotlin.streams.toList

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val adj = Array(n) { readln() }
        val l = range(1, n+1).toList().toMutableList()
        sort(l) { x,y -> x.compareTo(y) * (if (adj[x-1][y-1]=='1') 1 else -1) }
        println(l.joinToString(" "))
    }
}
