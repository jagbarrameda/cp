fun main() {
    var t = readln().toInt()
    while (t-->0) {
        val n = readln().toInt()
        println(if (n % 2 == 0) "Sakurako" else "Kosuke")
    }
}