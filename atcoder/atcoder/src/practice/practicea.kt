fun main() {
    val a = readln().toInt()
    val (b, c) = readln().split(" ").map { it.toInt() }
    val s = readln()
    println("${a + b + c} $s")
}