fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        var a = readln().split(' ').map { it.toInt() }.toIntArray()
        var b = readln().split(' ').map { it.toInt() }.toIntArray()
        if (a[0] != b[0]) {
            b.reverse()
        }
        var alice = false
        for (i in a.indices) {
            if (a[i] != b[i]) {
                alice = true
                break
            }
        }
        println(if (alice) "Alice" else "Bob")
    }
}
