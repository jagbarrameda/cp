import java.util.stream.IntStream.range
import kotlin.streams.toList

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        println("1 ${range(1, n - 2).toList().joinToString(" ")} 1 2")
    }
}
