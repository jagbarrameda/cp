fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val s = readln()
        println(s.count { it == '1' })
    }
}
