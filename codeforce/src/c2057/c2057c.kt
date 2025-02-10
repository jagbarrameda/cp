fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (l, r) = readln().split(" ").map { it.toInt() }
        var a = 0
        var mask = 1 shl 30
        while ((l and mask) == (r and mask)) {
            a = a or (l and mask)
            mask = mask shr 1
        }
        a = a or mask
        val b = a - 1
        var c = 0

        for (i in l..r) {
            if (i != a && i != b) {
                c = i
                break
            }
        }
        println("$a $b $c")
    }
}