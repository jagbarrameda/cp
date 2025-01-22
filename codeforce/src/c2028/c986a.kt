fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (n, a, b) = readln().split(" ").map { it.toInt() }
        val s = readln()
        if (a == 0 && b == 0) {
            println("YES")
            continue
        }

        var x = 0
        var y = 0
        var done = false
        var ans = false
        var loops = 0

        while (!done) {
            for (c in s) {
                when (c) {
                    'N' -> y++
                    'S' -> y--
                    'E' -> x++
                    'W' -> x--
                }
                if (x == a && y == b) {
                    done = true
                    ans = true
                    break
                }
            }
            loops++
            if (loops > 100) {
                done = true
            }
        }

        println(if (ans) "YES" else "NO")
    }
}
