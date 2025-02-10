fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }
    println(if (a * b == c || b * c == a || a * c == b) "Yes" else "No")
}