import java.util.Collections.sort

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val aa = readln().split(" ").map { it.toInt() }
        sort(aa)
        val d = IntArray(4)
        var b = false
        var j = 0 // in [0.. 3]
        var i = 1
        var lastUsed = 0
        while (i < aa.size && j < 2) {
            if (aa[i] == aa[i-1]) {
                d[j++] = aa[i]
                lastUsed = i
                i++
            }
            i++
        }
        b = (j == 2)
        if (b) {
            i = aa.size - 1
            j = 3
            while (i - 1 > lastUsed && j > 1) {
                if (aa[i] == aa[i - 1]) {
                    d[j--] = aa[i]
                    i--
                }
                i--
            }
            b = (j == 1)
        }

        if (b) {
            println("YES")
            println("${d[0]} ${d[1]} ${d[0]} ${d[3]} ${d[2]} ${d[1]} ${d[2]} ${d[3]}")
        } else {
            println("NO")
        }
    }
}
