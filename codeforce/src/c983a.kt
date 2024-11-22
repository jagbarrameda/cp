import kotlin.math.min

fun main() {
    var t = readln().toInt()
    while (t-->0) {
        val n = readln().toInt()
        val a = readln().split(" ").map { it.toInt() }
        val on = a.count { it == 1 }
        val off = a.size - on
        var min = ((on % 2) + (off % 2))/2
        var max = min(on, off)
        println("$min $max")
    }
}