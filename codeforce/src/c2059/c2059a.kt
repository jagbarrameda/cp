fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        println(
            if (readln().split(" ").distinct().size
                * readln().split(" ").distinct().size
                >= 3
            )
                "YES" else "NO"
        )
    }
}
