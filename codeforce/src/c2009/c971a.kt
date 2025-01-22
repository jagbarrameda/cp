fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        println(b - a)
    }
}